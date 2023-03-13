package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import project.dao.PostViewDAO;
import project.vo.PostRegistVO;
import project.vo.PostViewVO;

public class postView extends JFrame implements ActionListener{
	

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
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
	private JCheckBox ckvideophone;
	private JPanel panel_8;
	private JButton btnmodify;
	private JButton btndelete;
	private JPanel panel_9;
	private JTextArea tfposttext;
	private JLabel lblNewLabel_3;
	private JTextField tfpostcompany;
	private JLabel lblNewLabel_4;
	private JTextField tfposttype;
	
	PostViewDAO dao;
	private JPanel panel_10;
	private JTextField tfposttitle;
	private JLabel lblNewLabel_5;
	private JTextField textField_1;
	int num;
	String custid;
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try { postView
	 * frame = new postView(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	
	public postView(Number personalTradeNo, String ids) throws Exception{
		this.num = (int)personalTradeNo;
		this.custid = ids;
		
		PostViewVO vo = new PostViewVO();
		setBounds(100, 100, 597, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uAC1C\uC778\uAC70\uB798", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_2.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "\uAE00 \uB0B4\uC6A9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		//텍스트
		tfposttext = new JTextArea();
		panel_9.add(tfposttext, BorderLayout.CENTER);
		


		
		panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "\uC81C\uBAA9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new GridLayout(1, 0, 0, 0));
		
		//제목 
		tfposttitle = new JTextField();
		panel_10.add(tfposttitle);
		tfposttitle.setColumns(10);
		


		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uB9E4\uBB3C \uC815\uBCF4", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		//주소
		lblNewLabel = new JLabel("주소");
		panel_3.add(lblNewLabel);
		
		tfpostaddr = new JTextField();
		tfpostaddr.setEditable(false);
		panel_3.add(tfpostaddr);
		tfpostaddr.setColumns(10);
		
		


		
		//상세주소
		lblNewLabel_1 = new JLabel("상세주소");
		panel_3.add(lblNewLabel_1);
		
		tfpostdetailaddr = new JTextField();
		tfpostdetailaddr.setEditable(false);
		panel_3.add(tfpostdetailaddr);
		tfpostdetailaddr.setColumns(10);
		


		
		//보증금
		lblNewLabel_2 = new JLabel("보증금/월세");
		panel_3.add(lblNewLabel_2);
		
		tfpostmoney = new JTextField();
		panel_3.add(tfpostmoney);
		tfpostmoney.setColumns(10);

		
		//부동산 업체
		lblNewLabel_3 = new JLabel("부동산 업체명");
		panel_3.add(lblNewLabel_3);
		
		tfpostcompany = new JTextField();
		tfpostcompany.setEditable(false);
		panel_3.add(tfpostcompany);
		tfpostcompany.setColumns(10);
		


		
		//주거 종류
		lblNewLabel_4 = new JLabel("주거종류");
		panel_3.add(lblNewLabel_4);
		
		tfposttype = new JTextField();
		tfposttype.setEditable(false);
		panel_3.add(tfposttype);
		tfposttype.setColumns(10);
		


		
		//계약기간
		lblNewLabel_5 = new JLabel("계약기간");
		panel_3.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\uBCF4\uC548\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		panel_6.setBorder(new TitledBorder(null, "\uAE30\uBCF8\uC635\uC158", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		panel_8 = new JPanel();
		panel_1.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		//트레이드 번호에
		dao = new PostViewDAO();
		String registuserId = dao.getID(num);
		
		btnmodify = new JButton("수정");
		panel_8.add(btnmodify);
		
		btnmodify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(registuserId.equals(custid)) {
					String posttitle=tfposttitle.getText();
					String posttext=tfposttext.getText();
					String postmoney=tfpostmoney.getText();
					System.out.println(posttitle);

					PostViewVO vo=new PostViewVO(posttitle, posttext, postmoney);
					try {
						dao = new PostViewDAO();
						dao.modify(vo,num);
						System.out.println("게시글 수정 성공!");
						
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "게시글 수정 실패"+e1.getMessage());
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "동일한 ID가 아니라 수정이 불가능합니다");
				}
			}
		});
		
		btndelete = new JButton("삭제");
		panel_8.add(btndelete);
		setVisible(true);
		
		btndelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(registuserId.equals(custid)) {
					String posttitle=tfposttitle.getText();
					String posttext=tfposttext.getText();
					String postmoney=tfpostmoney.getText();
					System.out.println(posttitle);
					PostViewVO vo=new PostViewVO(posttitle, posttext, postmoney);
					
					try {
						dao.delete(vo, num);
						System.out.println("게시글 삭제 성공!");
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "게시글 삭제 실패"+e2.getMessage());
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "동일한 ID가 아니라 삭제가 불가능합니다");
				}
			}
		});
		
		
		//이벤트등록
		btnmodify.addActionListener(this);
		btndelete.addActionListener(this);
		
		dao = new PostViewDAO();
try {
	//		System.out.println("넘 " + num);
			PostViewVO vo1= dao.postSelect(num);
			String sido=vo1.getAreaSidoName();
			String addr=vo1.getDetailedAddresss();
			String company = vo1.getPostcompany();
			String type=vo1.getBuildingType();
			String contractdate=vo1.getContractdate();
			String title = vo1.getPosttitle();
			String text = vo1.getPosttext();
			String money = vo1.getPostmoney();
			String compa = vo1.getPostcompany();
			dao.postSelect(num);
			
//			System.out.println("번호: "+num);

			vo1.setAreaSidoName(sido);
			vo1.setDetailedAddresss(addr);
			vo1.setBuildingType(type);
			vo1.setContractdate(contractdate);
			vo1.setPosttitle(title);
			vo1.setPosttext(text);
			vo1.setPostmoney(money);
			vo1.setPostcompany(compa);
			
			tfpostaddr.setText(sido);
			tfpostdetailaddr.setText(addr);
			tfposttype.setText(type);
			tfpostcompany.setText(company);
			textField_1.setText(contractdate);
			tfposttitle.setText(title);
			tfposttext.setText(text);
			tfpostmoney.setText(money);
			tfpostcompany.setText(compa);
			
			String cctv=vo1.getCCTV();
			String window=vo1.getWindowgurad();
			String interphone=vo1.getInterphone();
			String entrance=vo1.getCommonentrance();
			String videophone=vo1.getVideophone();
			

			String aricon=vo1.getAirconditioner();
			String laundry=vo1.getLaundry();
			String internet=vo1.getInternet();
			String tv=vo1.getTv();
			String refrigerator=vo1.getRefrigerator();
			String microwave=vo1.getMicrowave();
			String closet=vo1.getCloset();
			String bed=vo1.getBed();
			String induction=vo1.getInduction();
			String shoecabinet=vo1.getShoecabinet();
			
		//	System.out.println(cctv);
		
			
			if(cctv.equals("Y")) {
				ckCCTV.setSelected(true);
			}else {
				
			}
			if(window.equals("Y")) {
				ckwindowgurad.setSelected(true);
			}else {
				
			}
			if(interphone.equals("Y")) {
				ckinterphone.setSelected(true);
			}else {
				
			}if(entrance.equals("Y")) {
				ckcommonentrance.setSelected(true);
			}else {
				
			}
			if(videophone.equals("Y")) {
				ckvideophone.setSelected(true);
			}else {
				
			}
			if(aricon.equals("Y")) {
				ckairconditioner.setSelected(true);
			}else {
				
			}if(laundry.equals("Y")) {
				cklaundry.setSelected(true);
			}else {
				
			}
			if(internet.equals("Y")) {
				ckinternet.setSelected(true);
			}else {
				
			}
			if(tv.equals("Y")) {
				cktv.setSelected(true);
			}else {
				
			}
			if(refrigerator.equals("Y")) {
				ckrefrigerator.setSelected(true);
			}else {
				
			}
			if(microwave.equals("Y")) {
				ckmicrowave.setSelected(true);
			}else {
				
			}
			if(closet.equals("Y")) {
				ckcloset.setSelected(true);
			}else {
				
			}
			if(bed.equals("Y")) {
				ckbed.setSelected(true);
			}else {
				
			}
			if(induction.equals("Y")) {
				ckinduction.setSelected(true);
			}else {
				
			}
			if(shoecabinet.equals("Y")) {
				ckshoecabinet.setSelected(true);
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
