package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class maintananceDAO {
	public maintananceDAO() throws Exception {
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

	public ArrayList maintananceshow(String id) throws Exception {
		String ids = id;
		System.out.println("아이디 : " + ids);
		String sql = "select "
				+ " c.customer_name, "
				+ " h.room_number, "
				+ " m.maintanance_fee_status_no, "
				+ " m.pay_fee_status, "
				+ " m2.* "
				+ " from "
				+ " customer c,"
				+ " house_resident_customer h, "
				+ " maintanance_fee_status m, "
				+ " maintanance_fee m2 "
				+ " where "
				+ " c.customer_no = h.customer_no "
				+ " and "
				+ " c.customer_id = '"+ids+"' "
				+ " and "
				+ " h.room_number = m.room_number "
				+ " and "
				+ " m.maintanance_fee = m2.maintanance_fee ";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
	
			temp.add(rs.getInt("MAINTANANCE_FEE"));
			temp.add(rs.getString("customer_name"));
			temp.add(rs.getInt("INTERNET"));
			temp.add(rs.getInt("PARKING_FEE"));
			temp.add(rs.getInt("CELANING_FEE"));
			temp.add(rs.getInt("TOTAL_FEE"));
			temp.add(rs.getDate("MAINTANANCE_ISSUE_DATE"));
			temp.add(rs.getDate("PAYMENT_DEADLINE"));
			temp.add(rs.getString("pay_fee_status"));
			list.add(temp);
			System.out.println(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	public String recentmaintanancefee(String id) throws Exception{
		String ids = id;
		System.out.println("아이디 : " + ids);
		Date idss = null;
		String sql = " select "
				+ " max(m2.payment_deadline) a "
				+ " from customer c, "
				+ " house_resident_customer h, "
				+ " maintanance_fee_status m, "
				+ " maintanance_fee m2 where c.customer_no = h.customer_no "
				+ " and "
				+ " c.customer_id = '"+ids+"' "
				+ " and " 
				+ " h.room_number = m.room_number "
				+ " and "
				+ " m.maintanance_fee = m2.maintanance_fee";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			idss = rs.getDate("a");
		}
		System.out.println("날짜 : " + idss);
		rs.close();

		String fee = null;
		String sql2 = " select m2.total_fee from customer c, "
				+ " house_resident_customer h, "
				+ " maintanance_fee_status m, "
				+ " maintanance_fee m2 where c.customer_no = h.customer_no "
				+ " and "
				+ " c.customer_id = '"+ids+"' "
				+ " and "
				+ " h.room_number = m.room_number "
				+ " and "
				+ " m.maintanance_fee = m2.maintanance_fee "
				+ " and "
				+ " m2.payment_deadline = '"+idss+"' ";
		stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(sql2);
		if(rs2.next()) {
			fee = rs2.getString("total_fee");
		}
		rs2.close();
		stmt.close();
		System.out.println("돈 : "+fee);
		
		return fee;
	}
	public String check_maintanance_fee(String id) throws Exception {
		String ids = id;
		System.out.println("아이디 : " + ids);
		Date idss = null;
		String sql = " select "
				+ " max(m2.payment_deadline) a "
				+ " from customer c, "
				+ " house_resident_customer h, "
				+ " maintanance_fee_status m, "
				+ " maintanance_fee m2 where c.customer_no = h.customer_no "
				+ " and "
				+ " c.customer_id = '"+ids+"' "
				+ " and " 
				+ " h.room_number = m.room_number "
				+ " and "
				+ " m.maintanance_fee = m2.maintanance_fee";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			idss = rs.getDate("a");
		}
		System.out.println("날짜 : " + idss);
		rs.close();
		
		String check = null;
		String sql2 = " select m.pay_fee_status from customer c, "
				+ " house_resident_customer h, "
				+ " maintanance_fee_status m, "
				+ " maintanance_fee m2 where c.customer_no = h.customer_no "
				+ " and "
				+ " c.customer_id = '" + ids + "' "
				+ " and "
				+ " h.room_number = m.room_number "
				+ " and "
				+ " m.maintanance_fee = m2.maintanance_fee "
				+ " and "
				+ " m2.payment_deadline = '"+idss+"' ";
		stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(sql2);
		if(rs2.next()) {
			check = rs2.getString("pay_fee_status");
		}
		rs2.close();
		stmt.close();
		System.out.println(check);
		return check;
	}
}