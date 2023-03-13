package project.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import project.vo.customer_mypage2VO;

public class customer_mypage2DAO {

	Connection con;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String user = "projects";
	String pass = "pass";
	PreparedStatement ps;
	Statement stmt = null;

	void connectDB() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}

	public customer_mypage2DAO() throws Exception {
		connectDB();
	}

	// 수정
	  public void modify(customer_mypage2VO vo, String id) throws Exception{
	         String ids = id;
	          String sql = "update customer set customer_name=?, customer_tel=?, customer_sex=?, customer_age=?, vehicle_own=?"
	         +" where customer_id='" +ids+"'";
	                ps = con.prepareStatement(sql);
	         
	         ps.setString(1, vo.getName());
	         ps.setString(2, vo.getTel());
	         ps.setString(3, vo.getSex());
	         ps.setInt(4, vo.getAge());
	         ps.setString(5, vo.getVehicle());
	         ps.executeUpdate();
	         ps.close();}
//	public void modify(customer_mypage2VO vo) throws Exception {
//		
//		String name = vo.getName();
//		String tel = vo.getTel();
//		String sex = vo.getSex();
//		int age = vo.getAge();
//		String vehicle = vo.getVehicle();
//	
//		String sql = "update customer set customer_name=?, customer_tel=?, customer_sex=?, customer_age=?, vehicle_own=?"
//				+ " where customer_id=?";
//		ps = con.prepareStatement(sql);
//
//ps.setString(1, name);
//		ps.setString(2, tel);
//		ps.setString(3, sex);
//		ps.setInt(4, age);
//	ps.setString(5, vehicle);
//		ps.executeUpdate();
//		ps.close();

	//}// 탈퇴

	public void delete(String id) throws Exception {
		String ids = id;
		String sql = "delete from customer " + " where customer_id=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, ids);
		ps.executeUpdate();
		ps.close();
		System.out.println("삭제 완료");}

//	}// 화면 띄우기
//
	public customer_mypage2VO printpage(String id) throws Exception {
		
		String ids = id;
		String sql = "select customer_id, customer_pw, customer_name, customer_tel, customer_sex, customer_age, vehicle_own from customer"
				+ " where customer_id='" + ids + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		customer_mypage2VO vo = new customer_mypage2VO();
		if (rs.next()) {
			vo.setId(rs.getString("customer_id"));
			vo.setPw(rs.getString("customer_pw"));
			vo.setName(rs.getString("customer_name"));
			vo.setTel(rs.getString("customer_tel"));
			vo.setSex(rs.getString("customer_sex"));
			vo.setAge(rs.getInt("customer_age"));
			vo.setVehicle(rs.getString("vehicle_own"));
		}
		rs.close();
		stmt.close();
		System.out.println(vo);
		return vo;
		   
}
}
