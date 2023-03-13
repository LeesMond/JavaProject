package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class alarm2DAO {
	String ids;
	public alarm2DAO() throws Exception{
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
	
	public ArrayList receiveAlarm(String custid) throws Exception {
		String id1 = custid;
		
		
		String sql =
				"select al.ALARM_LIST_NO, bo.BUILDING_OWNER_NAME, bo.BUILDING_OWNER_TEL, al.ALARM_TITLE, al.ALARM_TEXT from "
				+ "BUILDING_OWNER bo, ROOM r, BUILDING b, HOUSE_RESIDENT_CUSTOMER hrc, CUSTOMER c, ALARM_LIST al "
				+ "where bo.BUILDING_OWNER_NO = b.BUILDING_OWNER_NO "
				+ "and b.BUILDING_NO = r.BUILDING_NO "
				+ "and r.ROOM_NUMBER = hrc.ROOM_NUMBER "
				+ "and hrc.CUSTOMER_NO = c.CUSTOMER_NO "
				+ "and c.CUSTOMER_NO = al.CUSTOMER_NO "
				+ "and bo.BUILDING_OWNER_NO = al.BUILDING_OWNER_NO "
				+ "and c.CUSTOMER_ID = '" + id1 + "'";
		
		
		stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("ALARM_LIST_NO"));
			temp.add(rs.getString("BUILDING_OWNER_NAME"));
			temp.add(rs.getString("BUILDING_OWNER_TEL"));
			temp.add(rs.getString("ALARM_TITLE"));
			temp.add(rs.getString("ALARM_TEXT"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public String custalarmtext(String text) throws Exception{
		String tex = text;
		String te = null;
		String sql = "select ALARM_TEXT from ALARM_LIST where ALARM_TITLE = '" + tex + "'";
		
		stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			te = rs.getString("ALARM_TEXT");
		}
		rs.close();
		stmt.close();
		return te;
	}
}
