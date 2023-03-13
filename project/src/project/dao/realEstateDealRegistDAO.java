package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import project.vo.realEstateDealRegistVO;

public class realEstateDealRegistDAO {
	public realEstateDealRegistDAO() throws Exception {
		connectDB();
	}

	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String user = "projects";
	String pass = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	ResultSet rs = null;

	void connectDB() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}

	public void realEstateInsert(realEstateDealRegistVO vo, String ids, String addr, String deaddr) throws Exception {
		String id = ids;
		System.out.println("dao아이디 : " + id);
		System.out.println("1");

		int roomNumber = 0;
		int buildingNo = 0;
		String postaddress = addr;
		String postdaddress = deaddr;
		// 기본 입력 인서트
		String sql = " select buo.building_owner_no, r.room_number " + " from " + " area_sido asd, "
				+ " area_sigungu asg, " + " area_dong ad, " + " building b, " + " room r, " + " security_option so, "
				+ " basic_option bo, " + " building_owner buo " + " where " + " asd.area_sido_no=asg.area_sido_no "
				+ " and asg.area_sigungu_no=ad.area_sigungu_no " + " and ad.area_dong_no=b.area_dong_no "
				+ " and b.building_no=so.building_no " + " and b.building_no=r.building_no "
				+ " and r.room_number=bo.room_number " + " and buo.building_owner_no=b.building_owner_no "
				+ " and buo.building_owner_id = '" + ids + "' " + " and asd.area_sido_name = '" + postaddress + "' "
				+ " and r.detailed_addresss = '" + postdaddress + "'";
		// YJY, 서울시, 301호

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			buildingNo = rs.getInt("building_owner_no");
			roomNumber = rs.getInt("room_number");
		}
		System.out.println("주인 번호 : " + buildingNo);
		System.out.println("가구 번호 : " + roomNumber);
		rs.close();
		stmt.close();
//		stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery(sql2);
//		if(rs.next()) {
//			roomNumber = rs.getInt("room_number");
//			buildingNo = rs.getInt("building_owner_no");
//			// String realEstate = "2";
//		}
//		rs.close();
//		stmt.close();
//		System.out.println("가구번호 " + roomNumber);

		// 부동산 사업자는 랜덤으로 가져오기

		String sql2 = "insert into trade (TRADE_NO,ROOM_NUMBER,REAL_ESTATE_DEALER_NO,POSTTITLE,POSTTEXT,POSTDATE,POSTMONEY,BUILDING_OWNER_NO)"
				+ " VALUES(TRADE_NO.nextval,?,?,?,?, sysdate, ?,?)";

		ps = con.prepareStatement(sql2);
		System.out.println("여기까지 왔음");
		ps.setInt(1, roomNumber);
		ps.setInt(2, 2);
		ps.setString(3, vo.getPosttitle());
		ps.setString(4, vo.getPosttext());
		ps.setString(5, vo.getPostmoney());
		ps.setInt(6, buildingNo);
		ps.executeUpdate();
		ps.close();

	}

}
