package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.vo.OwnerMyPageVO;

public class OwnerMyPageDAO {
	public OwnerMyPageDAO() throws Exception {
		connectDB();
	}

	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String user = "projects";
	String pass = "pass";
	Statement stmt = null;
	PreparedStatement ps;
	String driver = "oracle.jdbc.driver.OracleDriver";

	void connectDB() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}

	public OwnerMyPageVO returnOwnerMyPage(String id) throws Exception {
		String ownerid = id;

		String sql = " select " + " BUILDING_OWNER_ID, " + " BUILDING_OWNER_PW, " + " BUILDING_OWNER_ADRESS, "
				+ " BUILDING_OWNER_TEL, " + " BUILDING_OWNER_BUSINESS_NUM, " + " BUILDING_OWNER_NAME "
				+ " from building_owner where BUILDING_OWNER_ID = '" + ownerid + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		OwnerMyPageVO vo = new OwnerMyPageVO();
		while (rs.next()) {
			vo.setId(rs.getString("BUILDING_OWNER_ID"));
			vo.setPw(rs.getString("BUILDING_OWNER_PW"));
			vo.setAddr(rs.getString("BUILDING_OWNER_ADRESS"));
			vo.setTel(rs.getString("BUILDING_OWNER_TEL"));
			vo.setBusinessNum(rs.getString("BUILDING_OWNER_BUSINESS_NUM"));
			vo.setName(rs.getString("BUILDING_OWNER_NAME"));
		}
		System.out.println(vo.getId());
		rs.close();
		stmt.close();
		return vo;
	}
	public void updateOwner(OwnerMyPageVO vo2, String ids) throws Exception {
		// TODO Auto-generated method stub
		String owner = ids;
		String name = vo2.getName();
		String tel = vo2.getTel();
		String addr = vo2.getAddr();
		String binum = vo2.getBusinessNum();
		System.out.println(name+tel+addr+binum);
		
		String sql = " update building_owner set BUILDING_OWNER_NAME = ?, "
				+ " BUILDING_OWNER_TEL = ?, "
				+ " BUILDING_OWNER_ADRESS = ?, "
				+ " BUILDING_OWNER_BUSINESS_NUM = ? "
				+ " where BUILDING_OWNER_ID = '"+owner+"'";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, tel);
		ps.setString(3, addr);
		ps.setString(4, binum);
		ps.executeUpdate();
		ps.close();
	}

}
