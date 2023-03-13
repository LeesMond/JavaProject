package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ownerinquiryDAO {
	public ownerinquiryDAO() throws Exception {
		connectDB();
	}

	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String user = "projects";
	String pass = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	ResultSet rs = null;

	void connectDB() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}
	public ArrayList selectinquiry(String id) throws Exception {
		
		String ids = id;
		int no = 0;
		String sql = "select BUILDING_OWNER_NO from building_owner where BUILDING_OWNER_ID = '" + ids + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			no = rs.getInt("building_owner_no");
		}
		System.out.println("건물주 번호 : "+no);
		rs.close();
		
		
		String sql2 = "select il.INQUIR_LIST_NUM, c.CUSTOMER_NAME, il.INQUIRY_TITLE, il.INQUIRY_TYPE, il.INQUIRY_TEXT, il.OWNER_CHECK from inquiry_list il, customer c "
				+ "where il.building_owner_no = "+no+" and il.customer_no = c.customer_no";
		stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(sql2);
		ArrayList list = new ArrayList();
		while(rs2.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs2.getInt("INQUIR_LIST_NUM"));
			temp.add(rs2.getString("CUSTOMER_NAME"));
			temp.add(rs2.getString("INQUIRY_TYPE"));
			temp.add(rs2.getString("INQUIRY_TITLE"));
			temp.add(rs2.getString("INQUIRY_TEXT"));
			temp.add(rs2.getString("OWNER_CHECK"));
			list.add(temp);
		}
		System.out.println(list);
		
		rs2.close();
		stmt.close();
		return list;
	}
	public String returnInquieyText(String title) throws Exception{
		String titles = title;
		String text = null;
		String sql = "select INQUIRY_TEXT from inquiry_list where INQUIRY_TITLE = '"+titles+"'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			text = rs.getString("INQUIRY_TEXT");
		}
		rs.close();
		stmt.close();
		return text;
	}
	public void checkInquiry(String title) throws Exception {
		String check = title;
		
		String sql = "update inquiry_list set owner_check = '확인' where INQUIRY_TITLE = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, check);
		ps.executeUpdate();
		ps.close();
	}
}
