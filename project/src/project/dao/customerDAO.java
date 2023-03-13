package project.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.vo.customerVO;

public class customerDAO {

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
	public customerDAO() throws Exception {
		connectDB();
	}

//회원가입
	public void regist(customerVO vo) throws Exception {

		String sql = "insert into customer "
				+ "(CUSTOMER_NO, CUSTOMER_ID, CUSTOMER_PW, CUSTOMER_TEL, CUSTOMER_NAME, CUSTOMER_SEX, CUSTOMER_AGE, VEHICLE_OWN) "
				+ "values(customer_seq.nextval,?,?,?,?,?,?,null)";
		ps = con.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());
		ps.setString(3, vo.getTel());
		ps.setString(4, vo.getName());
		ps.setString(5, vo.getSex());
		ps.setInt(6, vo.getAge());

		ps.executeUpdate();
		ps.close();
	}
	//아이디 중복확인
public String idcheck(String ID) throws Exception{
	String ids = ID;
	String sql = "select" + " CUSTOMER_ID"+ " from customer"+" where CUSTOMER_ID = '"+ids+"'" ;
	stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
     String custID = "";
     if(rs.next()) {
    	 custID = rs.getString("CUSTOMER_ID"); 
     }
		return custID;
		

}
}
