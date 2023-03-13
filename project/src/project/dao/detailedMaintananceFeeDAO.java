package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class detailedMaintananceFeeDAO {
	public detailedMaintananceFeeDAO() throws Exception {
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
	public ArrayList returnDetailedMain(String id, int maintan) throws Exception {
		String custid = id;
		int maintanDe = maintan;
		
		String sql = " SELECT DMF.MAINTANANCE_FEE, DMF.DETAILED_MAINTANANCE_FEE_NO, DMF.USAGE_FEE, DMF.BASIC_FEE, DMF.TYPE_NO, T.TYPE_NAME "
				+ " FROM CUSTOMER C, HOUSE_RESIDENT_CUSTOMER HRC, ROOM R, MAINTANANCE_FEE_STATUS MFS, MAINTANANCE_FEE MF, DETAILED_MAINTANANCE_FEE DMF, TYPE T "
				+ " WHERE CUSTOMER_ID = '"+custid+"' "
				+ " AND "
				+ " C.CUSTOMER_NO = HRC.CUSTOMER_NO "
				+ " AND "
				+ " R.ROOM_NUMBER = HRC.ROOM_NUMBER "
				+ " AND "
				+ " R.ROOM_NUMBER = MFS.ROOM_NUMBER "
				+ " AND "
				+ " MFS.MAINTANANCE_FEE = "+maintanDe+" "
				+ " AND "
				+ " MF.MAINTANANCE_FEE = MFS.MAINTANANCE_FEE "
				+ " AND "
				+ " MFS.MAINTANANCE_FEE = DMF.MAINTANANCE_FEE "
				+ " AND "
				+ " DMF.TYPE_NO = T.TYPE_NO ";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("MAINTANANCE_FEE"));
			temp.add(rs.getInt("DETAILED_MAINTANANCE_FEE_NO"));
			temp.add(rs.getInt("USAGE_FEE"));
			temp.add(rs.getInt("BASIC_FEE"));
			temp.add(rs.getInt("TYPE_NO"));
			temp.add(rs.getString("TYPE_NAME"));
			list.add(temp);
		}
		
		System.out.println(list);
		rs.close();
		stmt.close();
		return list;
		
	}
}
