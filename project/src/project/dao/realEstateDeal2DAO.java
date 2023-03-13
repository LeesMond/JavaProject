package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class realEstateDeal2DAO {
	public realEstateDeal2DAO() throws Exception {
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

	// 매매탭에서 매매글 올라온 목록 보여주기
	public ArrayList realList(String ids) throws Exception {
		String id = ids;
		ArrayList list = new ArrayList();
		System.out.println(id);

//		String sql="select "
//				+ "t.trade_no, bo.building_owner_id, t.POSTTITLE, asi.area_sido_name, bu.building_type "
//				+ "from "
//				+ "area_sido asi, area_sigungu ars, area_dong ad, building bu, room r, trade t, building_owner bo "
//				+ "where "
//				+ "asi.area_sido_no = ars.area_sido_no and "
//				+ "ars.area_sigungu_no = ad.area_sigungu_no and "
//				+ "ad.area_dong_no = bu.area_dong_no and "
//				+ "r.room_number = t.room_number and "
//				+ "bo.building_owner_no = bu.building_owner_no and "
//				+ "building_owner_id = '"+id+"'";

		String sql2 = "select t.TRADE_NO, bo.BUILDING_OWNER_ID, t.POSTTITLE, asd.AREA_SIDO_NAME, b.BUILDING_TYPE "
				+ "from AREA_SIDO asd, AREA_SIGUNGU asg, AREA_DONG ad, BUILDING b, ROOM r, TRADE t, BUILDING_OWNER bo "
				+ "where asd.AREA_SIDO_NO = asg.AREA_SIDO_NO " + "and asg.AREA_SIGUNGU_NO = ad.AREA_SIGUNGU_NO "
				+ "and ad.AREA_DONG_NO = b.AREA_DONG_NO " + "and b.BUILDING_NO = r.BUILDING_NO "
				+ "and r.ROOM_NUMBER = t.ROOM_NUMBER " + "and t.BUILDING_OWNER_NO = bo.BUILDING_OWNER_NO";

		// "매물번호", "작성자", "제목", "지역", "종류"
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql2);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("trade_no"));
			temp.add(rs.getString("building_owner_id"));
			temp.add(rs.getString("POSTTITLE"));
			temp.add(rs.getString("area_sido_name"));
			temp.add(rs.getString("building_type"));

			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 매매글탭에서 조건 검색시 그 리스트만 보여줌
	public ArrayList conditionalList(String sidoname) throws Exception {
		ArrayList list = new ArrayList();

		String sql = "select t.TRADE_NO, bo.BUILDING_OWNER_ID, t.POSTTITLE, asd.AREA_SIDO_NAME, b.BUILDING_TYPE "
				+ "from AREA_SIDO asd, AREA_SIGUNGU asg, AREA_DONG ad, BUILDING b, ROOM r, TRADE t, BUILDING_OWNER bo "
				+ "where asd.AREA_SIDO_NO = asg.AREA_SIDO_NO " + "and asg.AREA_SIGUNGU_NO = ad.AREA_SIGUNGU_NO "
				+ "and ad.AREA_DONG_NO = b.AREA_DONG_NO " + "and b.BUILDING_NO = r.BUILDING_NO "
				+ "and r.ROOM_NUMBER = t.ROOM_NUMBER " + "and t.BUILDING_OWNER_NO = bo.BUILDING_OWNER_NO "
				+ "and asd.AREA_SIDO_NAME = '" + sidoname + "'";
		System.out.println("sidoname" + sidoname);

		// "매물번호", "작성자", "제목", "지역", "종류"
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("trade_no"));
			temp.add(rs.getString("building_owner_id"));
			temp.add(rs.getString("POSTTITLE"));
			temp.add(rs.getString("area_sido_name"));
			temp.add(rs.getString("building_type"));

			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public String returnid(String id) throws Exception {
		String ids = id;
		String sql = "select building_owner_id from building_owner where building_owner_id = '" + ids + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String com = null;
		while (rs.next()) {
			com = rs.getString("building_owner_id");
		}
		rs.close();
		stmt.close();
		return com;
	}

}
