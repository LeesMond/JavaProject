package project.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import project.dao.LoginDAO;
import project.dao.OwnerMaintenance2DAO;

public class OwnerMaintenance2 extends JPanel {
	private JTable table;
	DefaultTableModel detable;
	JComboBox comCustomerSelect;
	JScrollPane scroll;
	ownerMainTableModel matable;
	OwnerMaintenance2DAO dao;
	LoginDAO LDAO;
	String custid;
	String ownerid;
	String ids;

	/**
	 * Create the panel.
	 */

	public OwnerMaintenance2(String id) throws Exception {
		this.ids = id;

		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC138\uC785\uC790 \uC120\uD0DD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		//스크롤에 고객명 출력
		String[] CustomerSelect = new OwnerMaintenance2DAO().searchCustomerName(ids);
		if(CustomerSelect == null) {			//고객이 없는 경우
			CustomerSelect = new String[0];
			CustomerSelect[0] = "고객이 없습니다.";
		}
		comCustomerSelect = new JComboBox(CustomerSelect);	//콤보박스 출력
		panel.add(comCustomerSelect);
		
		JButton searchbtn = new JButton("검색");
		panel.add(searchbtn);
		
		searchbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = (String)comCustomerSelect.getSelectedItem();
				try {
					ArrayList list = dao.MaintenanceInfo(ids,name);
					matable.data=list;
//					System.out.println(list);
					table.setModel(matable);
					matable.fireTableDataChanged();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uC138\uC785\uC790\uBCC4 \uAD00\uB9AC\uBE44", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		//세입자 목록 불러오기
		table = new JTable(matable);
		scrollPane.setViewportView(table);
		
		dao = new OwnerMaintenance2DAO();
		matable = new ownerMainTableModel();
		

		setVisible(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = 2;
				String name = String.valueOf(table.getValueAt(row, col));
				System.out.println(name);
			}
		});
		}
};

	class ownerMainTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = {"건물", "세대", "이름", "전화번호", "관리비", "납부"};
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
			
}// 비디오모델 클래스 끝
