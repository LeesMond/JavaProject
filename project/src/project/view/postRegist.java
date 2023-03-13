package project.view;

import java.awt.BorderLayout;
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
import javax.swing.border.TitledBorder;

import project.dao.PostRegistDAO;
import project.vo.PostRegistVO;

public class postRegist extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField tfposttitle;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JTextField tfpostaddr;
	private JLabel lblNewLabel_1;
	private JTextField tfpostdetailaddr;
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
	private JTextField tfpostmoney;
	private JPanel panel_7;
	private JButton btnregist;
	private JCheckBox ckvideophone;
	private JPanel panel_8;
	private JLabel lblNewLabel_3;
	private JTextField tfpostcompany;
	private JLabel lblNewLabel_4;

	PostRegistDAO dao;
	PostRegistVO vo;
	private JTextField tfposttext;
	private JTextField tfposttype;
	String ids;
	private JLabel lblNewLabel_5;
	private JTextField tfcontractdate;

	public postRegist(String id) throws Exception {
		this.ids = id;

		setBounds(100, 100, 597, 483);
		contentPane = new JPanel();
		contentPane.setBorder(
				new TitledBorder(null, "\uAC1C\uC778\uAC70\uB798", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		tfposttitle = new JTextField();
		panel_2.add(tfposttitle, BorderLayout.CENTER);
		tfposttitle.setColumns(10);

		panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));

		btnregist = new JButton("등록");
		panel_7.add(btnregist, BorderLayout.NORTH);

		panel_8 = new JPanel();
		panel_8.setBorder(
				new TitledBorder(null, "\uAE00 \uC791\uC131", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));

		tfposttext = new JTextField();
		panel_8.add(tfposttext);
		tfposttext.setColumns(10);

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

		tfpostaddr = new JTextField();
		tfpostaddr.setEditable(false);
		panel_3.add(tfpostaddr);
		tfpostaddr.setColumns(10);

		lblNewLabel_1 = new JLabel("상세주소");
		panel_3.add(lblNewLabel_1);

		tfpostdetailaddr = new JTextField();
		tfpostdetailaddr.setEditable(false);
		panel_3.add(tfpostdetailaddr);
		tfpostdetailaddr.setColumns(10);

		lblNewLabel_2 = new JLabel("보증금/월세");
		panel_3.add(lblNewLabel_2);

		tfpostmoney = new JTextField();
		panel_3.add(tfpostmoney);
		tfpostmoney.setColumns(10);

		lblNewLabel_3 = new JLabel("부동산 업체명");
		panel_3.add(lblNewLabel_3);

		tfpostcompany = new JTextField();
		tfpostcompany.setEditable(false);
		panel_3.add(tfpostcompany);
		tfpostcompany.setColumns(10);

		lblNewLabel_4 = new JLabel("주거종류");
		panel_3.add(lblNewLabel_4);

		tfposttype = new JTextField();
		tfposttype.setEditable(false);
		panel_3.add(tfposttype);
		tfposttype.setColumns(10);

		lblNewLabel_5 = new JLabel("계약기간");
		panel_3.add(lblNewLabel_5);

		tfcontractdate = new JTextField();
		tfcontractdate.setEditable(false);
		panel_3.add(tfcontractdate);
		tfcontractdate.setColumns(10);

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
		btnregist.addActionListener(this);

		// 창열면 id관련 정보 자동등록
		dao = new PostRegistDAO();

		try {

			PostRegistVO vo = dao.postSelect(id);
			String sido = vo.getAreaSidoName();
			String addr = vo.getDetailedAddresss();
			String company = vo.getPostCompany();
			String type = vo.getBuildingType();
			String contractdate = vo.getContractdate();
			dao.postSelect(id);

			System.out.println("아이디: " + id);

			// PostViewVO pvo = new PostViewVO();

			vo.setAreaSidoName(sido);
			vo.setDetailedAddresss(addr);
			vo.setBuildingType(type);
			vo.setContractdate(contractdate);

			tfpostaddr.setText(sido);
			tfpostdetailaddr.setText(addr);
			tfposttype.setText(type);
			tfpostcompany.setText(company);
			tfcontractdate.setText(contractdate);

			String cctv = vo.getCctv();
			String window = vo.getwindowGurad();
			String interphone = vo.getInterPhone();
			String entrance = vo.getCommonEntrance();
			String videophone = vo.getVideoPhone();

			String aricon = vo.getAirConditioner();
			String laundry = vo.getLaundry();
			String internet = vo.getInternet();
			String tv = vo.getTv();
			String refrigerator = vo.getRefrigerator();
			String microwave = vo.getMicrowave();
			String closet = vo.getCloset();
			String bed = vo.getBed();
			String induction = vo.getInduction();
			String shoecabinet = vo.getShoeCabinet();

			System.out.println(cctv);
			if (cctv.equals("Y")) {
				ckCCTV.setSelected(true);
			} else {

			}
			if (window.equals("Y")) {
				ckwindowgurad.setSelected(true);
			} else {

			}
			if (interphone.equals("Y")) {
				ckinterphone.setSelected(true);
			} else {

			}
			if (entrance.equals("Y")) {
				ckcommonentrance.setSelected(true);
			} else {

			}
			if (videophone.equals("Y")) {
				ckvideophone.setSelected(true);
			} else {

			}
			if (aricon.equals("Y")) {
				ckairconditioner.setSelected(true);
			} else {

			}
			if (laundry.equals("Y")) {
				cklaundry.setSelected(true);
			} else {

			}
			if (internet.equals("Y")) {
				ckinternet.setSelected(true);
			} else {

			}
			if (tv.equals("Y")) {
				cktv.setSelected(true);
			} else {

			}
			if (refrigerator.equals("Y")) {
				ckrefrigerator.setSelected(true);
			} else {

			}
			if (microwave.equals("Y")) {
				ckmicrowave.setSelected(true);
			} else {

			}
			if (closet.equals("Y")) {
				ckcloset.setSelected(true);
			} else {

			}
			if (bed.equals("Y")) {
				ckbed.setSelected(true);
			} else {

			}
			if (induction.equals("Y")) {
				ckinduction.setSelected(true);
			} else {

			}
			if (shoecabinet.equals("Y")) {
				ckshoecabinet.setSelected(true);
			} else {

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();

		// 등록버튼 누르면 게시글테이블에 데이터입력
		if (o == btnregist) {
			try {
				String posttitle = tfposttitle.getText();
				String posttext = tfposttext.getText();
				String postmoney = tfpostmoney.getText();

				System.out.println("뷰 아이디:" + ids);

				PostRegistVO vo = new PostRegistVO();

				dao.postInsert(vo, ids, posttitle, posttext, postmoney);
				clearScreen();
				JOptionPane.showMessageDialog(null, "등록 완료");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "등록 실패" + e.getMessage());
				clearScreen();
			}
		}

	}

	private void close() {
		// TODO Auto-generated method stub

	}

	public void clearScreen() {
		tfposttitle.setText("");
		tfposttext.setText("");
		tfpostaddr.setText("");
		tfpostdetailaddr.setText("");
		tfpostmoney.setText("");
		tfpostcompany.setText("");
	}

}
