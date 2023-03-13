package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDAO {

	// constructor
	public PostDAO() throws Exception {
		connectDB();
	}

	Connection con = null;
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa"; // @localhost:1521:kibwa
	String user = "projects";
	String pass = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";

	void connectDB() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}

	public void PostDAO() throws Exception {
		connectDB();
	}

	// 시도명 검색
	public ArrayList searchSidoName() throws Exception {

		ArrayList list = new ArrayList();
		String sql = "select asd.area_sido_name " + "from area_sido asd, " + "area_sigungu asg,  " + "area_dong ad, "
				+ "building b, " + "room r, " + "house_resident_customer hrc, " + "customer c, " + "personal_trade pt "
				+ "where " + "asd.area_sido_no=asg.area_sido_no " + "and asg.area_sigungu_no=ad.area_sigungu_no "
				+ "and ad.area_dong_no=b.area_dong_no " + "and b.building_no=r.building_no "
				+ "and r.room_number=hrc.room_number " + "and hrc.customer_no=c.customer_no "
				+ "and c.customer_no=pt.customer_no";

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String s = rs.getString("area_sido_name");
			list.add(s);
		}
		rs.close();
		stmt.close();

		return list;
	}

	// 지역명 검색 후 목록 나오게하기
	public ArrayList postList(String sidoName) throws Exception {
		String sido = sidoName;
		String sql = "select pt.personal_trade_no, " + "pt.posttitle, " + "asd.area_sido_name, " + "b.building_type, "
				+ "pt.postdate " + "from area_sido asd, " + "area_sigungu asg, " + "area_dong ad, " + "building b, "
				+ "room r, " + "house_resident_customer hrc, " + "customer c, " + "personal_trade pt " + "where "
				+ "asd.area_sido_no=asg.area_sido_no " + "and asg.area_sigungu_no=ad.area_sigungu_no "
				+ "and ad.area_dong_no=b.area_dong_no " + "and b.building_no=r.building_no "
				+ "and r.room_number=hrc.room_number " + "and hrc.customer_no=c.customer_no "
				+ "and c.customer_no=pt.customer_no " + "and asd.area_sido_name = '" + sido + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("personal_trade_no"));
			temp.add(rs.getString("posttitle"));
			temp.add(rs.getString("area_sido_name"));
			temp.add(rs.getString("building_type"));
			temp.add(rs.getDate("postdate"));
			list.add(temp);
			System.out.println(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 개인거래 탭에서 올라온 목록 보여주기
	public ArrayList posts() throws Exception {
		ArrayList list = new ArrayList();
		System.out.println("200");
		String sql = "select pt.personal_trade_no, " + "pt.posttitle, " + "asd.area_sido_name, " + "b.building_type, "
				+ "pt.postdate " + "from area_sido asd, " + "area_sigungu asg, " + "area_dong ad, " + "building b, "
				+ "room r, " + "house_resident_customer hrc, " + "customer c, " + "personal_trade pt " + "where "
				+ "asd.area_sido_no=asg.area_sido_no " + "and asg.area_sigungu_no=ad.area_sigungu_no "
				+ "and ad.area_dong_no=b.area_dong_no " + "and b.building_no=r.building_no "
				+ "and r.room_number=hrc.room_number " + "and hrc.customer_no=c.customer_no "
				+ "and c.customer_no=pt.customer_no";

		// "번호","제목","지역명","종류","작성날짜"
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("personal_trade_no"));
			temp.add(rs.getString("posttitle"));
			temp.add(rs.getString("area_sido_name"));
			temp.add(rs.getString("building_type"));
			temp.add(rs.getDate("postdate"));

			list.add(temp);
			System.out.println(temp);
			System.out.println("100");
		}
		rs.close();
		stmt.close();
		return list;
	}

	public String returnid(String id) throws Exception {
		String ids = id;
		String sql = "select customer_id from customer where customer_id = '" + ids + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String com = null;
		while (rs.next()) {
			com = rs.getString("customer_id");
		}
		rs.close();
		stmt.close();
		return com;
	}
}
