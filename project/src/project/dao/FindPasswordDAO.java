package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import project.view.FindPassword;
import project.vo.customerVO;

public class FindPasswordDAO {
	public FindPasswordDAO() throws Exception {
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
	//아이디와 전화번호 입력시 비밀번호 찾기
	
	
	
	
	public void searchIdTel(String pw,String id, String tel) throws Exception{
		String sql = "update customer set customer_pw=? where customer_id=? and customer_tel=?";
				ps = con.prepareStatement(sql);
			
		ps.setString(1, pw);
		ps.setString(2, id);
		ps.setString(3, tel);
		ps.executeUpdate();
		ps.close();
		
		
	}


}
