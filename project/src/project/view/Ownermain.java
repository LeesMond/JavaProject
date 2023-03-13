package project.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Ownermain extends JFrame {
	buildingOwner_mypage2 ownermy;
	OwnerAlarm2 owneral;
	OwnerInquiry2 ownerin;
	post2 ownerre;
	realEstateDeal2 ownerred;
	OwnerMaintenance2 ownerma;
	String ownerid;
	public Ownermain(String id) throws Exception {
		this.ownerid = id;
		setTitle("건물주 페이지("+ownerid+")");
		ownermy = new buildingOwner_mypage2(ownerid);
		ownerin = new OwnerInquiry2(ownerid);
		owneral = new OwnerAlarm2(ownerid);
		ownerma = new OwnerMaintenance2(ownerid);
		ownerre = new post2(ownerid);
		ownerred = new realEstateDeal2(ownerid);
		
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("관리비", ownerma);
		pane.addTab("개인 거래", ownerre);
		pane.addTab("매매", ownerred);
		pane.addTab("문의", ownerin);
		pane.addTab("알림", owneral);
		pane.addTab("마이페이지", ownermy);
		
		
		pane.setSelectedIndex(5);
		getContentPane().add("Center", pane);
		setSize(800, 500);
		setVisible(true);
	}
}
