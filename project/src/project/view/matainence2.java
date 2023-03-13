package project.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import project.dao.maintananceDAO;

public class matainence2 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	String custid;
	maintananceDAO dao;
	custmainTableModel matable;
	private JTable table;
	detailedMaintananceFee dmfee;
	/**
	 * Create the panel.
	 * 
	 * @return
	 * @throws Exception
	 */
	public matainence2(String ids) throws Exception {
		this.custid = ids;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\uAD00\uB9AC\uBE44", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uAD00\uB9AC\uBE44 \uAC1C\uC694", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("이번달 총 관리비 ");
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		dao = new maintananceDAO();
		String fee = dao.recentmaintanancefee(custid);
		System.out.println("maintanance_fee : " + fee);
		textField.setText(fee);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC774\uBC88\uB2EC \uB0A9\uC785 \uC0C1\uD0DC", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("이번달 납입 여부");
		panel_2.add(lblNewLabel_1);

		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		String pay_check = dao.check_maintanance_fee(custid);
		if (pay_check.equals("Y")) {
			textField_1.setText("납입 완료");
		} else if (pay_check.equals("N")) {
			textField_1.setText("납입 미완료");
		}

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uAD00\uB9AC\uBE44 \uB0B4\uC5ED", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		table = new JTable(matable);
		scrollPane.setViewportView(table);

		matable = new custmainTableModel();
		ArrayList list = dao.maintananceshow(custid);
		System.out.println(list);
		matable.data = list;
		table.setModel(matable);
		matable.fireTableDataChanged();
		setVisible(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				int col = 0;
				int maintanance_fee_no = (int) table.getValueAt(row, col);
				try {
					dmfee = new detailedMaintananceFee(custid, maintanance_fee_no);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
};

class custmainTableModel extends AbstractTableModel {

	ArrayList data = new ArrayList();
	String[] columnNames = { "관리비 번호", "고객 이름", "인터넷비", "주차비", "청소비", "총 금액", "발급일", "납일말일", "입금 내역" };

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
//	      기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
	public String getColumnName(int col) {
		return columnNames[col];
	}
}
