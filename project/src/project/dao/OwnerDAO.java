package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import project.vo.OwnerVO;
import project.vo.customerVO;

public class OwnerDAO {

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
	public OwnerDAO() throws Exception {
		connectDB();
	}
//회원가입
	public void regist(OwnerVO vo) throws Exception {
		String sql = "insert into building_owner"
				+"(building_owner_no, building_owner_name, building_owner_tel, building_owner_adress, building_owner_business_num, building_owner_id, building_owner_pw)"
				+"values(building_owner_seq.nextval,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, vo.getName());
		ps.setString(2, vo.getTel());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getBuisness());
		ps.setString(5, vo.getID());
		ps.setString(6, vo.getPW());

		ps.executeUpdate();
		ps.close();
	}
		//아이디 중복확인
	public String idcheck(String ID) throws Exception{
		String ids = ID;
		String sql = "select" + " building_owner_id" + " from building_owner"+" where building_owner_id = '"+ids+"'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
	     String ownerID = "";
	     if(rs.next()) {
	    	 ownerID = rs.getString("building_owner_id"); 
	     }
			return ownerID;
			

	}
}