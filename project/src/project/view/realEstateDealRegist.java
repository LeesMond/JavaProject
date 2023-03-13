package project.view;

import java.awt.BorderLayout;
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
import javax.swing.border.TitledBorder;

import project.dao.realEstateDealRegistDAO;
import project.vo.realEstateDealRegistVO;
import project.vo.LoginVO;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class realEstateDealRegist extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField realEstateTitle;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JTextField realEstateAddress;
	private JLabel lblNewLabel_1;
	private JTextField realEstateDAddress;
	private JPanel panel_4;
	private JPanel panel_5;
	private JCheckBox ckCCTV;
	private JCheckBox ckwindowgurad;
	private JCheckBox ckinterphone;
	private JCheckBox ckcommonentrance;
	private JPanel panel_6;
	private JCheckBox ckairconditioner;
	private JCheckBox cklaundry;
	private JCheckBox ckinternet;
	private JCheckBox cktv;
	private JCheckBox ckrefrigerator;
	private JCheckBox ckmicrowave;
	private JCheckBox ckcloset;
	private JCheckBox ckbed;
	private JCheckBox ckinduction;
	private JCheckBox ckshoecabinet;
	private JLabel lblNewLabel_2;
	private JTextField realEstateDeposit;
	private JPanel panel_7;
	private JButton btnNewButton;
	private JCheckBox ckvideophone;
	private JLabel lblNewLabel_3;
	private JTextField realEstateBusiness;
	private JLabel lblNewLabel_4;
	private JPanel panel_8;
	private JTextArea realEstateWriting;

	realEstateDealRegistDAO dao;
	private JTextField tfposttext;
	private JTextField textField;
	String ids;

	public realEstateDealRegist(String id) throws Exception {
		this.ids = id;
		setBounds(100, 100, 597, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uBD80\uB3D9\uC0B0 \uB9E4\uBB3C \uAC70\uB798", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		realEstateTitle = new JTextField();
		panel_2.add(realEstateTitle, BorderLayout.NORTH);
		realEstateTitle.setColumns(10);

		panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));

		btnNewButton = new JButton("등록");
		panel_7.add(btnNewButton, BorderLayout.NORTH);

		panel_8 = new JPanel();
		panel_8.setBorder(
				new TitledBorder(null, "\uAE00 \uC791\uC131", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));

		realEstateWriting = new JTextArea();
		panel_8.add(realEstateWriting, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uB9E4\uBB3C \uC815\uBCF4 \uC785\uB825", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel = new JLabel("주소");
		panel_3.add(lblNewLabel);

		realEstateAddress = new JTextField();
		panel_3.add(realEstateAddress);
		realEstateAddress.setColumns(10);

		lblNewLabel_1 = new JLabel("상세주소");
		panel_3.add(lblNewLabel_1);

		realEstateDAddress = new JTextField();
		panel_3.add(realEstateDAddress);
		realEstateDAddress.setColumns(10);

		lblNewLabel_2 = new JLabel("보증금/월세");
		panel_3.add(lblNewLabel_2);

		realEstateDeposit = new JTextField();
		panel_3.add(realEstateDeposit);
		realEstateDeposit.setColumns(10);

		lblNewLabel_3 = new JLabel("부동산 업체명");
		panel_3.add(lblNewLabel_3);

		realEstateBusiness = new JTextField();
		realEstateBusiness.setEditable(false);
		panel_3.add(realEstateBusiness);
		realEstateBusiness.setColumns(10);

		lblNewLabel_4 = new JLabel("주거종류");
		panel_3.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		panel_3.add(textField);

		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "\uBCF4\uC548\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		ckCCTV = new JCheckBox("CCTV");
		ckCCTV.setEnabled(false);
		panel_5.add(ckCCTV);

		ckwindowgurad = new JCheckBox("방범창");
		ckwindowgurad.setEnabled(false);
		panel_5.add(ckwindowgurad);

		ckinterphone = new JCheckBox("인터폰");
		ckinterphone.setEnabled(false);
		panel_5.add(ckinterphone);

		ckcommonentrance = new JCheckBox("공동현관");
		ckcommonentrance.setEnabled(false);
		panel_5.add(ckcommonentrance);

		ckvideophone = new JCheckBox("비디오폰");
		ckvideophone.setEnabled(false);
		panel_5.add(ckvideophone);

		panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "\uAE30\uBCF8\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));

		ckairconditioner = new JCheckBox("에어컨");
		ckairconditioner.setEnabled(false);
		panel_6.add(ckairconditioner);

		cklaundry = new JCheckBox("세탁기");
		cklaundry.setEnabled(false);
		panel_6.add(cklaundry);

		ckinternet = new JCheckBox("인터넷");
		ckinternet.setEnabled(false);
		panel_6.add(ckinternet);

		cktv = new JCheckBox("TV");
		cktv.setEnabled(false);
		panel_6.add(cktv);

		ckrefrigerator = new JCheckBox("냉장고");
		ckrefrigerator.setEnabled(false);
		panel_6.add(ckrefrigerator);

		ckmicrowave = new JCheckBox("전자레인지");
		ckmicrowave.setEnabled(false);
		panel_6.add(ckmicrowave);

		ckcloset = new JCheckBox("옷장");
		ckcloset.setEnabled(false);
		panel_6.add(ckcloset);

		ckbed = new JCheckBox("침대");
		ckbed.setEnabled(false);
		panel_6.add(ckbed);

		ckinduction = new JCheckBox("인덕션");
		ckinduction.setEnabled(false);
		panel_6.add(ckinduction);

		ckshoecabinet = new JCheckBox("신발장");
		ckshoecabinet.setEnabled(false);
		panel_6.add(ckshoecabinet);
		setVisible(true);
		// 이벤트 등록
		btnNewButton.addActionListener(this);

	}

	// 등록버튼 누르면 게시판테이블에 데이터입력
	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();

		if (o == btnNewButton) {
			try {
				String posttype = textField.getText(); // 콤보박스
				String posttitle = realEstateTitle.getText(); // 제목
				String posttext = realEstateWriting.getText(); // 내용
				String postmoney = realEstateDeposit.getText(); // 월세
				String postaddress = realEstateAddress.getText(); // 주소
				String postdaddress = realEstateDAddress.getText(); // 상세주소

				System.out.println("뷰 아이디 : " + ids);
				System.out.println("posttitle" + posttitle);

				realEstateDealRegistVO vo = new realEstateDealRegistVO(posttitle, posttype, posttext, postmoney,
						postaddress, postdaddress, ids);

				dao = new realEstateDealRegistDAO();
				dao.realEstateInsert(vo, ids, postaddress, postdaddress);
				clearScreen();
				close();

				JOptionPane.showMessageDialog(null, "게시물 등록 성공");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "게시글 등록 실패" + e.getMessage());
				clearScreen();
			}

		}
	}

	// 체크박스 추가하기
	private void close() {
		// TODO Auto-generated method stub

	}

	public void clearScreen() {

	}

}
