package project.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import project.dao.detailedMaintananceFeeDAO;

public class detailedMaintananceFee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String custid;
	int main_fee_no;
	maindetailTableModel madetable;
	detailedMaintananceFeeDAO dao;

	public detailedMaintananceFee(String id, int maintanance_fee_no) throws Exception {
		this.custid = id;
		this.main_fee_no = maintanance_fee_no;
		setTitle("상세관리비("+custid+")");
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uC0C1\uC138 \uAD00\uB9AC\uBE44", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(madetable);
		scrollPane.setViewportView(table);
		
		dao = new detailedMaintananceFeeDAO();
		madetable = new maindetailTableModel();
		ArrayList list = dao.returnDetailedMain(custid, main_fee_no);
		madetable.data = list;
		table.setModel(madetable);
		madetable.fireTableDataChanged();
		setSize(600, 200);
		setVisible(true);
	}
	class maindetailTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = {"관리비 번호", "상세 관리비 번호", "기본료", "사용료", "분류번호", "분류명"};

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
