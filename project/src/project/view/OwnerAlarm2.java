package project.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import project.dao.OwnerAlarm2DAO;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class OwnerAlarm2 extends JPanel {
	private JTable table;
	private JTextField alarmtitle;
	private JTextField custnameField;
	private JTextArea textArea;
	private String name;
	JButton sendbtn;
	OwnerAlarm2DAO dao;
	AlarmTableModel matable;
	String ids;
	String custid;
	String ownerid;
	JScrollPane scroll;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	
	public OwnerAlarm2(String id) throws Exception {
		this.ids=id;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC54C\uB9BC \uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC81C\uBAA9 \uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		//알림 제목
		alarmtitle = new JTextField();
		panel_2.add(alarmtitle, BorderLayout.CENTER);
		alarmtitle.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\uB0B4\uC6A9 \uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		//알림 내용
		JTextArea alarmtext;
		alarmtext = new JTextArea();
		panel_3.add(alarmtext, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC138\uC785\uC790 \uBA85", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		//세입자 명
		custnameField = new JTextField();
		custnameField.setEditable(false);
		panel_4.add(custnameField, BorderLayout.CENTER);
		custnameField.setColumns(10);
		
		JButton sendbtn = new JButton("전송");
		panel.add(sendbtn, BorderLayout.SOUTH);
		
		sendbtn.addActionListener(new ActionListener() {		//메세지 전송
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = alarmtitle.getText();
				String text = alarmtext.getText();
				String cuname = custnameField.getText();
				
				try {
					dao = new OwnerAlarm2DAO();
					dao.sendAlarm(id, name, text, cuname);
					JOptionPane.showMessageDialog(null, "전송완료");
					custnameField.setText("");
					alarmtitle.setText("");
					alarmtext.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});					//메세지 전송 끝
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uC138\uC785\uC790 \uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		//로그인한 관리자에 따른 세입자들 불러오기
		table = new JTable(matable);
		scrollPane.setViewportView(table);
		
		dao = new OwnerAlarm2DAO();
		matable = new AlarmTableModel();
		
		ArrayList list = dao.CustInfo(ids);
		matable.data=list;
//		System.out.println(list);
		table.setModel(matable);
		matable.fireTableDataChanged();
		setVisible(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = 2;
				String name = String.valueOf(table.getValueAt(row, col));
				custnameField.setText(name);
			
				alarmtitle.setText("");
				alarmtext.setText("");
			}
		});
	}
	
		void clearScreen() {
			alarmtitle.setText(null);
			textArea.setText(null);
		}
}

class AlarmTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = {"건물", "세대", "이름", "전화번호", "특이사항"};
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
