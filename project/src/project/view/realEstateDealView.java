package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import project.dao.realEstateDealViewDAO;
import project.vo.realEstateDealViewVO;

import javax.swing.JTextArea;

public class realEstateDealView extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JPanel panel_4;
	private JPanel panel_5;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JPanel panel_6;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JCheckBox chckbxNewCheckBox_6;
	private JCheckBox chckbxNewCheckBox_7;
	private JCheckBox chckbxNewCheckBox_8;
	private JCheckBox chckbxNewCheckBox_9;
	private JCheckBox chckbxNewCheckBox_10;
	private JCheckBox chckbxNewCheckBox_11;
	private JCheckBox chckbxNewCheckBox_12;
	private JCheckBox checkBox;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JPanel panel_7;
	private JCheckBox chckbxNewCheckBox_13;
	private JPanel panel_8;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JTextField textField_5;
	private JPanel panel_9;
	private JTextArea textArea;
	realEstateDealViewDAO dao;
	String ownerid;
	int num;

	public realEstateDealView(String id, String inquirynum) throws Exception {
		setTitle("수정,삭제");
		this.ownerid = id;
		this.num = Integer.parseInt(inquirynum);
		setBounds(100, 100, 597, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uBD80\uB3D9\uC0B0 \uB9E4\uB9E4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		dao = new realEstateDealViewDAO();
		realEstateDealViewVO vo = dao.postSelect(num);
		
		String posttitle = vo.getPosttitle();
		String posttext = vo.getPosttext();
		String postmoney = vo.getPostmoney();
		String air_condition = vo.getAIR_CONDITIONER();
		String laundry = vo.getLAUNDRY();
		String internet = vo.getINTERNET();
		String tv = vo.getTV();
		String refrigerator = vo.getREFRIGERATOR();
		String microwave = vo.getMICROWAVE();
		String closet = vo.getCLOSET();
		String bed = vo.getBED();
		String induction = vo.getINDUCTION();
		String shoe_cabinet = vo.getSHOE_CABINET();
		String cctv = vo.getCCTV();
		String window_garad = vo.getWINDOW_GURAD();
		String interphone = vo.getINTERPHONE();
		String common_entrance = vo.getCOMMON_ENTRANCE();
		String videophone = vo.getVIDEOPHONE();
		String real_estate_name = vo.getReal_estate_name();
		String area_dong_name = vo.getArea_dong_name();
		String area_sido_name = vo.getArea_sido_name();
		String building_type = vo.getBuilding_type();

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		panel_2.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		textField.setText(posttitle);

		panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));

		panel_9 = new JPanel();
		panel_9.setBorder(
				new TitledBorder(null, "\uAE00 \uB0B4\uC6A9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		panel_9.add(textArea, BorderLayout.CENTER);
		textArea.setText(posttext);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uB9E4\uBB3C \uC815\uBCF4", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel = new JLabel("주소");
		panel_3.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(area_sido_name);

		lblNewLabel_1 = new JLabel("상세주소");
		panel_3.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(area_dong_name);

		lblNewLabel_2 = new JLabel("보증금/월세");
		panel_3.add(lblNewLabel_2);

		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(postmoney);

		lblNewLabel_3 = new JLabel("부동산 업체명");
		panel_3.add(lblNewLabel_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(real_estate_name);

		lblNewLabel_4 = new JLabel("주거종류");
		panel_3.add(lblNewLabel_4);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText(building_type);

		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "\uBCF4\uC548\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		chckbxNewCheckBox = new JCheckBox("CCTV");
		chckbxNewCheckBox.setEnabled(false);
		panel_5.add(chckbxNewCheckBox);
		if(cctv.equals("Y")) {
			chckbxNewCheckBox.setSelected(true);
		}

		chckbxNewCheckBox_1 = new JCheckBox("방범창");
		chckbxNewCheckBox_1.setEnabled(false);
		panel_5.add(chckbxNewCheckBox_1);
		if(window_garad.equals("Y")) {
			chckbxNewCheckBox_1.setSelected(true);
		}

		chckbxNewCheckBox_2 = new JCheckBox("인터폰");
		chckbxNewCheckBox_2.setEnabled(false);
		panel_5.add(chckbxNewCheckBox_2);
		if(interphone.equals("Y")) {
			chckbxNewCheckBox_2.setSelected(true);
		}

		chckbxNewCheckBox_3 = new JCheckBox("공동현관");
		chckbxNewCheckBox_3.setEnabled(false);
		panel_5.add(chckbxNewCheckBox_3);
		if(common_entrance.equals("Y")) {
			chckbxNewCheckBox_3.setSelected(true);
		}

		chckbxNewCheckBox_13 = new JCheckBox("비디오폰");
		chckbxNewCheckBox_13.setEnabled(false);
		panel_5.add(chckbxNewCheckBox_13);
		if(videophone.equals("Y")) {
			chckbxNewCheckBox_13.setSelected(true);
		}

		panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "\uAE30\uBCF8\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));

		chckbxNewCheckBox_4 = new JCheckBox("에어컨");
		chckbxNewCheckBox_4.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_4);
		if(air_condition.equals("Y")) {
			chckbxNewCheckBox_4.setSelected(true);
		}

		chckbxNewCheckBox_5 = new JCheckBox("세탁기");
		chckbxNewCheckBox_5.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_5);
		if(laundry.equals("Y")) {
			chckbxNewCheckBox_5.setSelected(true);
		}

		chckbxNewCheckBox_6 = new JCheckBox("인터넷");
		chckbxNewCheckBox_6.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_6);
		if(internet.equals("Y")) {
			chckbxNewCheckBox_6.setSelected(true);
		}

		chckbxNewCheckBox_7 = new JCheckBox("TV");
		chckbxNewCheckBox_7.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_7);
		if(tv.equals("Y")) {
			chckbxNewCheckBox_7.setSelected(true);
		}

		chckbxNewCheckBox_8 = new JCheckBox("냉장고");
		chckbxNewCheckBox_8.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_8);
		if(refrigerator.equals("Y")) {
			chckbxNewCheckBox_8.setSelected(true);
		}

		chckbxNewCheckBox_9 = new JCheckBox("전자레인지");
		chckbxNewCheckBox_9.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_9);
		if(microwave.equals("Y")) {
			chckbxNewCheckBox_9.setSelected(true);
		}

		chckbxNewCheckBox_10 = new JCheckBox("옷장");
		chckbxNewCheckBox_10.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_10);
		if(closet.equals("Y")) {
			chckbxNewCheckBox_10.setSelected(true);
		}

		chckbxNewCheckBox_11 = new JCheckBox("침대");
		chckbxNewCheckBox_11.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_11);
		if(bed.equals("Y")) {
			chckbxNewCheckBox_11.setSelected(true);
		}

		chckbxNewCheckBox_12 = new JCheckBox("인덕션");
		chckbxNewCheckBox_12.setEnabled(false);
		panel_6.add(chckbxNewCheckBox_12);
		if(induction.equals("Y")) {
			chckbxNewCheckBox_12.setSelected(true);
		}

		checkBox = new JCheckBox("신발장");
		checkBox.setEnabled(false);
		panel_6.add(checkBox);
		if(shoe_cabinet.equals("Y")) {
			checkBox.setSelected(true);
		}

		panel_8 = new JPanel();
		panel_1.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		

		btnNewButton_1 = new JButton("수정");
		panel_8.add(btnNewButton_1);
		dao = new realEstateDealViewDAO();
		String ids = dao.getID(num);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ids.equals(ownerid)) {
					String posttitles = textField.getText();
					String posttexts = textArea.getText();
					String postmoneys = textField_3.getText();
					realEstateDealViewVO vo = new realEstateDealViewVO(posttitles, posttexts, postmoneys);
					try {
						dao = new realEstateDealViewDAO();
						dao.modify(vo, num);
						JOptionPane.showMessageDialog(null, "수정 완료");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}else {
					JOptionPane.showMessageDialog(null, "동일한 ID가 아니라 수정이 불가합니다.");
				}
			}
		});

		btnNewButton_2 = new JButton("삭제");
		panel_8.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ids.equals(ownerid)) {
					try {
						dao = new realEstateDealViewDAO();
						dao.delete(num);
						JOptionPane.showMessageDialog(null, "삭제 완료");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}else {
					JOptionPane.showMessageDialog(null, "동일한 ID가 아니라 삭제가 불가합니다.");
				}
			}
		});
		setVisible(true);
	}

}
