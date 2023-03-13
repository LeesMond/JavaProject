package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class OwnerMaintenance2DAO {
	public OwnerMaintenance2DAO() throws Exception{
		connectDB();
	}
	
	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String user = "projects";
	String pass = "pass";
	Statement stmt = null;
	PreparedStatement ps;
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	void connectDB() throws Exception{
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}
	
	public ArrayList MaintenanceInfo(String custid, String custname)throws Exception{
		String id1 = custid;
		String cname = custname;
		String sql =
				"select asd.AREA_SIDO_NAME, asg.AREA_SIGUNGU_NAME, ad.AREA_DONG_NAME, r.DETAILED_ADDRESSS, c.CUSTOMER_NAME, c.CUSTOMER_TEL, mf.TOTAL_FEE, mfs.PAY_FEE_STATUS from "
				+ "HOUSE_RESIDENT_CUSTOMER hrc, ROOM r, BUILDING b, CUSTOMER c, MAINTANANCE_FEE mf, MAINTANANCE_FEE_STATUS mfs, AREA_SIDO asd, AREA_SIGUNGU asg, AREA_DONG ad, BUILDING_OWNER bo "
				+ "where hrc.ROOM_NUMBER = r.ROOM_NUMBER "
				+ "and r.BUILDING_NO = b.BUILDING_NO "
				+ "and b.AREA_DONG_NO = ad.AREA_DONG_NO "
				+ "and b.AREA_DONG_NO = ad.AREA_DONG_NO "
				+ "and ad.AREA_SIGUNGU_NO = asg.AREA_SIGUNGU_NO "
				+ "and asg.AREA_SIDO_NO = asd.AREA_SIDO_NO "
				+ "and r.ROOM_NUMBER = mfs.ROOM_NUMBER "
				+ "and mfs.MAINTANANCE_FEE = mf.MAINTANANCE_FEE "
				+ "and hrc.CUSTOMER_NO = c.CUSTOMER_NO "
				+ "and b.BUILDING_OWNER_NO = bo.BUILDING_OWNER_NO "
				+ "and bo.BUILDING_OWNER_ID = '" + id1 + "'"
				+ "and c.CUSTOMER_NAME = '" + cname + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			String sidoname = rs.getString("AREA_SIDO_NAME");
			String sigunguname = rs.getString("AREA_SIGUNGU_NAME");
			String dongname = rs.getString("AREA_DONG_NAME");
			String totalname = sidoname + " " + sigunguname + " " + dongname;
			temp.add(totalname);
			temp.add(rs.getString("DETAILED_ADDRESSS"));
			temp.add(rs.getString("CUSTOMER_NAME"));
			temp.add(rs.getString("CUSTOMER_TEL"));
			temp.add(rs.getInt("TOTAL_FEE"));
			temp.add(rs.getString("PAY_FEE_STATUS"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public String[] searchCustomerName(String ownerid) throws Exception{
		String id1 = ownerid;

		String sql = "select c.CUSTOMER_NAME "
				+ "from CUSTOMER c, HOUSE_RESIDENT_CUSTOMER hrc, ROOM r, BUILDING b, BUILDING_OWNER bo "
				+ "where c.CUSTOMER_NO = hrc.CUSTOMER_NO "
				+ "and hrc.ROOM_NUMBER = r.ROOM_NUMBER "
				+ "and r.BUILDING_NO = b.BUILDING_NO "
				+ "and b.BUILDING_OWNER_NO = bo.BUILDING_OWNER_NO "
				+ "and '" + id1 + "' = bo.BUILDING_OWNER_ID";

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			String s = rs.getString("CUSTOMER_NAME");
			list.add(s);
		}
		stmt.close();
		rs.close();
		
		return (String[]) list.toArray(new String[0]);
	}
}
