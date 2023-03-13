package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class inquiry2DAO {
	public inquiry2DAO() throws Exception {
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

	public void insertinquiry(String id, String type, String title, String text) throws Exception {
		String ids = id;
		int owner_no = 0;
		String types = type;
		String titles = title;
		String texts = text;
		int customer_no = 0;

		System.out.println(ids + types + titles + texts);

		String sql = "SELECT BO.BUILDING_OWNER_NO "
				+ " FROM CUSTOMER C, HOUSE_RESIDENT_CUSTOMER HC, ROOM R, BUILDING B, BUILDING_OWNER BO "
				+ " WHERE CUSTOMER_ID = '" + ids + "' AND C.CUSTOMER_NO = HC.CUSTOMER_NO "
				+ " AND HC.ROOM_NUMBER = R.ROOM_NUMBER " + " AND R.BUILDING_NO = B.BUILDING_NO "
				+ " AND B.BUILDING_OWNER_NO = BO.BUILDING_OWNER_NO ";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			owner_no = rs.getInt("BUILDING_OWNER_NO");
		}
		System.out.println(owner_no);
		rs.close();

		String sql2 = "select customer_no from customer where customer_id = '" + ids + "'";
		stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(sql2);
		if (rs2.next()) {
			customer_no = rs2.getInt("customer_no");
		}
		System.out.println(customer_no);
		rs2.close();
		stmt.close();

		String sql3 = "INSERT INTO INQUIRY_LIST (INQUIR_LIST_NUM, CUSTOMER_NO, BUILDING_OWNER_NO, INQUIRY_TITLE, INQUIRY_TYPE, INQUIRY_TEXT) "
				+ " VALUES (inquiry_list_seq.NEXTVAL,?,?,?,?,?)";
		ps = con.prepareStatement(sql3);
		ps.setInt(1, customer_no);
		ps.setInt(2, owner_no);
		ps.setString(3, titles);
		ps.setString(4, types);
		ps.setString(5, texts);
		ps.executeUpdate();
		ps.close();

	}
	public ArrayList returnInquiry(String id) throws Exception {
		String sql = "SELECT IL.INQUIR_LIST_NUM, IL.INQUIRY_TYPE, IL.INQUIRY_TITLE, IL.OWNER_CHECK FROM INQUIRY_LIST IL, CUSTOMER C "
				+ " WHERE C.CUSTOMER_NO = IL.CUSTOMER_NO AND CUSTOMER_ID = '" +id+ "' ORDER BY IL.INQUIR_LIST_NUM";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("INQUIR_LIST_NUM"));
			temp.add(rs.getString("INQUIRY_TYPE"));
			temp.add(rs.getString("INQUIRY_TITLE"));
			temp.add(rs.getString("OWNER_CHECK"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		
		return list;
	}

}
