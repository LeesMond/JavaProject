package project.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import project.dao.LoginDAO;
import project.dao.alarm2DAO;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

public class alarm2 extends JPanel {
	private JTable table;
	custAlarmTableModel matable;
	alarm2DAO dao;
	LoginDAO LDAO;
	String custid;
	String ownerid;
	String ids;
	private JTextField textField;

	/**
	 * Create the panel.
	 */

	public alarm2(String id) throws Exception {
		this.ids = id;
		setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC54C\uB9BC \uB0B4\uC6A9", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC54C\uB9BC \uC0C1\uC138 \uB0B4\uC6A9", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		panel_3.add(textArea, BorderLayout.CENTER);

		textField = new JTextField();
		textField.setEditable(false);
		panel_1.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		setVisible(true);

		// 알람 테이블 출력
		table = new JTable(matable);
		scrollPane.setViewportView(table);

		dao = new alarm2DAO();
		matable = new custAlarmTableModel();

		ArrayList list = dao.receiveAlarm(ids);
		matable.data = list;
		// System.out.println(list);
		table.setModel(matable);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);

		JButton btnNewButton = new JButton("새로고침");
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectedTable();
			}
		});
		setVisible(true);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = 3;
				String title = String.valueOf(table.getValueAt(row, col));
				textField.setText(title);
				try {
					textArea.setText(dao.custalarmtext(title));
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});

	}

	void selectedTable() {
		try {
			ArrayList list = dao.receiveAlarm(ids);
			matable.data = list;
			table.setModel(matable);
			matable.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
};

class custAlarmTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "번호", "이름", "전화번호", "제목", "내용" };

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
//	      기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
	public String getColumnName(int col) {
		return columnNames[col];
	}

}// 비디오모델 클래스 끝
