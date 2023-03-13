package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import project.vo.LoginVO;

public class LoginDAO {
	public LoginDAO() throws Exception {
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

	// 로직 시작
	// 고객 로그인
	public String customerLogin(LoginVO vo) throws Exception {
		String id = vo.getID();
		String pass = vo.getPassword();
		System.out.printf("로그인dao : %s %s", id, pass);
		String sql = "select customer_id, customer_pw from customer where customer_id = '" + id + "' and customer_pw= '"
				+ pass + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			String db = rs.getString("customer_id");
			if (id.equals(db) && pass.equals(rs.getString("customer_pw"))) {
				rs.close();
				stmt.close();
				return db;
			}
		} else {
			throw new Exception("로그인 오류 : 일치하지 않는 아이디 혹은 비밀번호 입니다");
		}
		rs.close();
		stmt.close();
		return null;
	}

	public String ownerLogin(LoginVO vo) throws Exception {
		String id = vo.getID();
		String pass = vo.getPassword();
		System.out.printf("관리자 로그인dao : %s %s \n", id, pass);
		String sql = "select building_owner_id, building_owner_pw from building_owner where building_owner_id = '" + id
				+ "' and building_owner_pw = '" + pass + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			String db = rs.getString("building_owner_id");
			if (id.equals(db) && pass.equals(rs.getString("building_owner_pw"))) {
				rs.close();
				stmt.close();
				return db;
			}
		} else {
			throw new Exception("로그인 오류 : 일치하지 않는 아이디 혹은 비밀번호 입니다");
		}
		rs.close();
		stmt.close();
		return null;
		}
}