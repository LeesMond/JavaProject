package project.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import project.dao.inquiry2DAO;

public class inquiry2 extends JPanel {
	private JTextField titleText;
	private JTable table;
	inquiry2DAO dao;
	String ids;
	custinquiryTableModel cutable;
	inquiry2 in2;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public inquiry2(String id) throws Exception {
		this.ids = id;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uBB38\uC758 \uC885\uB958", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"시설파손", "주차 문의", "건의 사항", "기타 사항"}));
		panel_2.add(comboBox, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uBB38\uC758 \uB0B4\uC6A9 \uC791\uC131", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		titleText = new JTextField();
		panel_4.add(titleText, BorderLayout.CENTER);
		titleText.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\uBB38\uC758 \uB0B4\uC6A9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JTextArea inquiryTextArea = new JTextArea();
		panel_5.add(inquiryTextArea, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("제출");
		panel_3.add(btnNewButton, BorderLayout.SOUTH);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String type = (String)comboBox.getSelectedItem();
				String title = titleText.getText();
				String text = inquiryTextArea.getText();
					try {
						dao = new inquiry2DAO();
						dao.insertinquiry(id, type, title, text);
						JOptionPane.showMessageDialog(null, "제출 완료");
						titleText.setText("");
						inquiryTextArea.setText("");
						cutable = new custinquiryTableModel();
						selectedTable();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uBB38\uC758 \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(cutable);
		cutable = new custinquiryTableModel();
		dao = new inquiry2DAO();
		ArrayList list = dao.returnInquiry(ids);
		cutable.data = list;
		table.setModel(cutable);
		scrollPane.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JButton btnNewButton_1 = new JButton("새로고침");
		panel_6.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectedTable();
			}
		});
	
	}
	
	void selectedTable() {
		try {			
			ArrayList list = dao.returnInquiry(ids);
			cutable.data = list;
			table.setModel(cutable);
			cutable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	class custinquiryTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = {"문의 번호", "문의 종류", "문의 제목", "관리자 체크"};

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
