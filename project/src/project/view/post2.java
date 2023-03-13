package project.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import project.dao.PostDAO;
import project.dao.PostViewDAO;
import project.view.post2.RecentListTableModel;
import project.vo.PostViewVO;
import javax.swing.JFormattedTextField;

public class post2 extends JPanel implements ActionListener {
	private JTextField textField;
	private JTable table;
	JComboBox csidoname;
	JButton btnsearch;
	String ids;
	RecentListTableModel tmPost;
	PostDAO dao;
	postView pview;
	int num;

	public post2(String id) throws Exception {

		this.ids = id;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uAC8C\uC2DC\uAE00 \uAC80\uC0C9", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JComboBox csidoname = new JComboBox();
		csidoname.setModel(new DefaultComboBoxModel(new String[] { "지역선택", "서울시", "경기도", "인천시" }));
		panel_1.add(csidoname);

		JButton btnsearch = new JButton("검색");
		panel_1.add(btnsearch);

		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				if (o == btnsearch) {
					String sidoname = (String) csidoname.getSelectedItem();
					try {
						ArrayList temp = dao.postList(sidoname);
						tmPost.data = temp;
						table.setModel(tmPost);
						tmPost.fireTableDataChanged();

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "검색실패" + e.getMessage());
					}
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uAC8C\uC2DC\uAE00 \uC791\uC131", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton_1 = new JButton("작성하기");
		panel_2.add(btnNewButton_1, BorderLayout.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dao = new PostDAO();
					String tf = dao.returnid(ids);
					System.out.println(tf);
					if (tf.equals(ids)) {
						try {
							new postRegist(ids);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} // --------------------------------------------------------

					} else {
						JOptionPane.showMessageDialog(null, "고객만 작성할수 있습니다.");
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "고객만 작성할수 있습니다.");
				}
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uAC8C\uC2DC\uAE00 \uBAA9\uB85D", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		// 이벤트 등록
		btnsearch.addActionListener(this);

		// Jtable에 마우스클릭 이벤트
		table = new JTable(tmPost);
		scrollPane.setViewportView(table);
		dao = new PostDAO();
		tmPost = new RecentListTableModel();
		ArrayList list = dao.posts();
		tmPost.data = list;
		table.setModel(tmPost);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		
		JButton btnNewButton = new JButton("새로고침");
		panel_8.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectedTable();
			}
		});
		

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = 0;
				int nums = (int) table.getValueAt(row, col);
				PostViewVO vo = new PostViewVO();
				try {
					pview = new postView(nums, ids);
					// System.out.println("nums : " + nums);

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setVisible(true);

	}
	void selectedTable() {
		try {
			ArrayList list = dao.posts();
			tmPost.data = list;
			table.setModel(tmPost);
			tmPost.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 검색하면 지역명에 따라 목록나오기

	void selectPost() {
		String sidoname = (String) csidoname.getSelectedItem();
		try {
			ArrayList list = dao.postList(sidoname);
			tmPost.data = list;
			table.setModel(tmPost);
			tmPost.fireTableDataChanged();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "검색실패" + e.getMessage());
		}
	}

	// 첫화면 개인간 거래 목록 불러오기
	class RecentListTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "번호", "제목", "지역", "종류", "작성날짜" };

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
