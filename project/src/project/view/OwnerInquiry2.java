package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import project.dao.ownerinquiryDAO;

public class OwnerInquiry2 extends JPanel {
	ownerinquiryTableModel owtable;
	ownerinquiryDAO dao;
	private JTable table;
	String ownerid;
	private JTextField titleTextfield;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public OwnerInquiry2(String id) throws Exception {
		this.ownerid = id;
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uBB38\uC758 \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		titleTextfield = new JTextField();
		titleTextfield.setEditable(false);
		panel_2.add(titleTextfield, BorderLayout.CENTER);
		titleTextfield.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uC0C1\uC138 \uBB38\uC758 \uB0B4\uC5ED", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JTextArea inquiryTextArea = new JTextArea();
		inquiryTextArea.setEditable(false);
		panel_3.add(inquiryTextArea, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("확인");
		panel_3.add(btnNewButton, BorderLayout.SOUTH);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = titleTextfield.getText();
				try {
					dao = new ownerinquiryDAO();
					dao.checkInquiry(text);
					selectedTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uBB38\uC758 \uBC1B\uC740 \uB0B4\uC5ED", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable(owtable);
		scrollPane.setViewportView(table);

		dao = new ownerinquiryDAO();
		owtable = new ownerinquiryTableModel();
		ArrayList list = dao.selectinquiry(ownerid);
		System.out.println("ownerinquiry :" + list);
		owtable.data = list;
		table.setModel(owtable);
		owtable.fireTableDataChanged();
		setVisible(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = 3;
				String inquirynum = String.valueOf(table.getValueAt(row, col));
				titleTextfield.setText(inquirynum);
				try {
					inquiryTextArea.setText(dao.returnInquieyText(inquirynum));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	void selectedTable() { 
		try {
			ArrayList list = dao.selectinquiry(ownerid);
			owtable.data = list;
			table.setModel(owtable);
			owtable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class ownerinquiryTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "문의 순서", "세입자 이름", "문의 종류", "문의 제목", "문의 내용", "내용 확인" };

		// =============================================================
		// 1. 기본적인 TabelModel 만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		// ===============================================================
		// 2. 지정된 컬럼명으로 변환하기
		//
//		      기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

}
