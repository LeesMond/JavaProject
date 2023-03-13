package project.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class customermain extends JFrame{
	customer_mypage2 custmy;
	inquiry2 custin;
	alarm2 custal;
	matainence2 custma;
	post2 custpo;
	realEstateDeal2 custred;
	String custid;
	

	public customermain(String id) throws Exception {
		this.custid = id;
		setTitle("고객 페이지 ("+ custid +")");
		custmy = new customer_mypage2(custid);
		custin = new inquiry2(custid);
		custal = new alarm2(custid);
		custma = new matainence2(custid);
		custpo = new post2(custid);
		custred = new realEstateDeal2(custid);
		
		
		JTabbedPane pane = new JTabbedPane();
		
		pane.addTab("관리비", custma);
		pane.addTab("개인 거래", custpo);
		pane.addTab("매매", custred);
		pane.addTab("문의", custin);
		pane.addTab("알림", custal);
		pane.addTab("마이페이지", custmy);
		
		pane.setSelectedIndex(5);
		getContentPane().add("Center", pane);
		setSize(800, 500);
		setVisible(true);

	}
	
}
