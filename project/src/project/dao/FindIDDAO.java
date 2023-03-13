
package project.dao;

import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import project.vo.customerVO;

public class FindIDDAO {
	public FindIDDAO() throws Exception {
		connectDB();
	}

	Connection con;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String user = "projects";
	String pass = "pass";
	PreparedStatement ps = null;
	Statement stmt = null;

	void connectDB() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}

	// 전화번호 검색으로 아이디 찾기

	public String searchTel(String tel) throws Exception {
		String tels = tel;
		String sql = "select" + " customer_id" + " from customer" + " where customer_tel = '" + tels + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String custid = "";
		if (rs.next()) {
			custid = rs.getString("customer_id");

		}
		return custid;
	}
}
