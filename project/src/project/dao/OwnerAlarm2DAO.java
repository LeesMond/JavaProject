package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OwnerAlarm2DAO {
	public OwnerAlarm2DAO() throws Exception{
		connectDB();
	}
	
	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String user = "projects";
	String pass = "pass";
	Statement stmt = null;
	PreparedStatement ps;
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	void connectDB() throws Exception{
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}
	
	public ArrayList CustInfo(String ownerid) throws Exception{
		String id1 = ownerid;
//		System.out.println("관리자 아이디 : " + id1);
		String sql = 
				"select asd.AREA_SIDO_NAME, asg.AREA_SIGUNGU_NAME, ad.AREA_DONG_NAME, r.DETAILED_ADDRESSS, c.CUSTOMER_NAME, c.CUSTOMER_TEL, hrc.SPECIAL_NOTE "
				+ "from HOUSE_RESIDENT_CUSTOMER hrc, ROOM r, BUILDING b, BUILDING_OWNER bo, CUSTOMER c, AREA_SIDO asd, AREA_SIGUNGU asg, AREA_DONG ad "
				+ "where hrc.ROOM_NUMBER = r.ROOM_NUMBER "
				+ "and r.BUILDING_NO = b.BUILDING_NO "
				+ "and b.AREA_DONG_NO = ad.AREA_DONG_NO "
				+ "and ad.AREA_SIGUNGU_NO = asg.AREA_SIGUNGU_NO "
				+ "and asg.AREA_SIDO_NO = asd.AREA_SIDO_NO "
				+ "and hrc.CUSTOMER_NO = c.CUSTOMER_NO "
				+ "and b.BUILDING_OWNER_NO = bo.BUILDING_OWNER_NO "
				+ "and bo.BUILDING_OWNER_ID = '" + id1 + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			String sidoname = rs.getString("AREA_SIDO_NAME");
			String sigunguname = rs.getString("AREA_SIGUNGU_NAME");
			String dongname = rs.getString("AREA_DONG_NAME");
			String totalname = sidoname + " " + sigunguname + " " + dongname;
			temp.add(totalname);
			temp.add(rs.getString("DETAILED_ADDRESSS"));
			temp.add(rs.getString("CUSTOMER_NAME"));
			temp.add(rs.getString("CUSTOMER_TEL"));
			temp.add(rs.getString("SPECIAL_NOTE"));
			list.add(temp);
//			System.out.println(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public void sendAlarm(String ID, String title, String text, String cuname) throws Exception{
		String ids = ID;
		String tit = title;
		String tex = text;
		String cname = cuname;
		int owner_no = 0;
		int cust_no = 0;
		String sqlcname = "select CUSTOMER_NO from CUSTOMER where CUSTOMER_NAME = '" + cname + "'";
		stmt=con.createStatement();
		ResultSet rs1 = stmt.executeQuery(sqlcname);
		if(rs1.next()) {
			cust_no = rs1.getInt("CUSTOMER_NO");
		}
//		System.out.println(cust_no);
		rs1.close();
		
		String sqlownerid = "select BUILDING_OWNER_NO from BUILDING_OWNER where BUILDING_OWNER_ID = '" + ids + "'";
		stmt=con.createStatement();
		ResultSet rs2 = stmt.executeQuery(sqlownerid);
		if(rs2.next()) {
			owner_no = rs2.getInt("BUILDING_OWNER_NO");
		}
//		System.out.println(owner_no);
		rs2.close();
		stmt.close();
		
		String sqlin = 
				"insert into ALARM_LIST(ALARM_LIST_NO, ALARM_TITLE, BUILDING_OWNER_NO, CUSTOMER_NO, ALARM_TEXT) "
				+ "values(alarm_list_seq.nextval,?,?,?,?)";

		ps=con.prepareStatement(sqlin);
		ps.setString(1, tit);
		ps.setInt(2, owner_no);
		ps.setInt(3, cust_no);
		ps.setString(4, tex);
		ps.executeUpdate();
		ps.close();
	}
}