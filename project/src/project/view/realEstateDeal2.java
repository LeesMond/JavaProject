package project.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import project.dao.realEstateDeal2DAO;
import project.vo.realEstateDeal2VO;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class realEstateDeal2 extends JPanel {
	private JTable table;

	DefaultTableModel matable;
	realEstateDeal2DAO dao;
	String ids;
	realEstateDealView redview;
	int num;

	/**
	 * 여기 매매페이지
	 * 
	 * @throws Exception
	 */
	public realEstateDeal2(String id) throws Exception {
		this.ids = id;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uB9E4\uB9E4\uAE00 \uBAA9\uB85D", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		// 매매글 목록 불러오기
		table = new JTable(matable);
		scrollPane.setViewportView(table);
		dao = new realEstateDeal2DAO();
		matable = new DefaultTableModel();
		ArrayList list = dao.realList(id);
		System.out.println(list);
		matable.data = list;
		table.setModel(matable);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);

		JButton btnNewButton_2 = new JButton("새로고침");
		panel_4.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectedTable();
			}
		});

		// 매매글 목록 클릭시 새창 띄우기
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = 0;
				String inquirynum = String.valueOf(table.getValueAt(row, col));
				try {
//					inquiryTextArea.setText(dao.realInquiey(inquirynum));
					redview = new realEstateDealView(ids, inquirynum);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		});

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uB9E4\uB9E4\uAE00 \uAC80\uC0C9", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "서울시", "경기도", "인천시" }));

		JButton btnNewButton = new JButton("검색");
		panel_2.add(btnNewButton);

		// 검색시 조건에 맞는 리스트만 출력
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sidoname = (String) comboBox.getSelectedItem();
					table = new JTable(matable);
					scrollPane.setViewportView(table);
					dao = new realEstateDeal2DAO();
					matable = new DefaultTableModel();
					ArrayList list = dao.conditionalList(sidoname);
					System.out.println(list);
					matable.data = list;
					table.setModel(matable);
					matable.fireTableDataChanged();

					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int row = table.getSelectedRow();
							int col = 0;
							String inquirynum = String.valueOf(table.getValueAt(row, col));
							try {
//								inquiryTextArea.setText(dao.realInquiey(inquirynum));
								redview = new realEstateDealView(ids, inquirynum);
							} catch (Exception e2) {
								// TODO: handle exception
								e2.printStackTrace();
							}
						}

					});

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

		});

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uB9E4\uB9E4\uAE00 \uC791\uC131", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton_1 = new JButton("작성하기");
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dao = new realEstateDeal2DAO();
					String tf = dao.returnid(ids);
					System.out.println(tf);
					if (tf.equals(ids)) {
						try {
							new realEstateDealRegist(ids);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} // --------------------------------------------------------

					} else {
						JOptionPane.showMessageDialog(null, "건물주만 작성할수 있습니다.");
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "건물주만 작성할수 있습니다.");
				}
			}
		});
	
		setVisible(true);
	}

	class DefaultTableModel extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "매물번호", "작성자", "제목", "지역", "종류" };

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

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
	void selectedTable() {
		try {
			ArrayList list = dao.realList(ids);
			System.out.println(list);
			matable.data = list;
			table.setModel(matable);
			matable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
