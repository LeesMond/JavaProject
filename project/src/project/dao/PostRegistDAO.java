package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.vo.PostRegistVO;

public class PostRegistDAO {
	public PostRegistDAO() throws Exception {
		connect();
	}

	Connection con = null;
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:kibwa";
	String db_id = "projects";
	String db_pwd = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	ResultSet rs = null;
	public String[] information;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
			System.out.println("디비에 연결되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("디비를 찾을 수 없습니다.");
		} catch (SQLException se) {
			System.out.println("sql명령어 오류");
		}
	}

	// 텍스트로 받기
	public PostRegistVO postSelect(String id) throws Exception {
		PostRegistVO vo = new PostRegistVO();

		String sql = "select " 
				+ "r.detailed_addresss address, "
				+ "asd.area_sido_name sido,"
				+ "hrc.contract_date contractdate," 
				+ "b.building_type type, " 
				+ "red.real_estate_name, "
				+ "so.cctv cctv, " 
				+ "so.window_gurad gurad, " 
				+ "so.interphone interphone, "
				+ "so.common_entrance entrance, " 
				+ "so.videophone videophone, " 
				+ "bo.air_conditioner airconditioner, "
				+ "bo.laundry laundry, " 
				+ "bo.internet internet, " 
				+ "bo.tv tv, " 
				+ "bo.refrigerator refrigerator, "
				+ "bo.microwave microwave, " 
				+ "bo.closet closet, " 
				+ "bo.bed bed, " 
				+ "bo.induction induction, "
				+ "bo.shoe_cabinet shoecabinet " 
				+ "from " 
				+ "real_estate_dealer red, " 
				+ "personal_trade pt, "
				+ "room r," 
				+ "customer c," 
				+ "area_sido asd," 
				+ "area_sigungu asg," 
				+ "area_dong ad, " 
				+ "building b,"
				+ "security_option so," 
				+ "basic_option bo," 
				+ "house_resident_customer hrc " 
				+ "where "
				+ "asd.area_sido_no=asg.area_sido_no " 
				+ "and asg.area_sigungu_no=ad.area_sigungu_no "
				+ "and ad.area_dong_no=b.area_dong_no " 
				+ "and so.building_no=b.building_no "
				+ "and b.building_no=r.building_no "
				+ "and r.room_number=hrc.room_number "
				+ "and c.customer_no=hrc.customer_no " 
				+ "and r.room_number=bo.room_number "
				+ "and pt.real_estate_dealer_no = red.real_estate_dealer_no " 
				+ "and c.customer_id='" + id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setDetailedAddresss(rs.getString("address"));
			vo.setAreaSidoName(rs.getString("sido"));
			vo.setContractdate(rs.getString("contractdate"));
			vo.setBuildingType(rs.getString("type"));

			vo.setCctv(rs.getString("cctv"));
			vo.setwindowGurad(rs.getString("gurad"));
			vo.setInterPhone(rs.getString("interphone"));
			vo.setCommonEntrance(rs.getString("entrance"));
			vo.setVideoPhone(rs.getString("videophone"));
			vo.setAirConditioner(rs.getString("airconditioner"));
			vo.setLaundry(rs.getString("laundry"));
			vo.setInternet(rs.getString("internet"));
			vo.setTv(rs.getString("tv"));
			vo.setRefrigerator(rs.getString("refrigerator"));
			vo.setMicrowave(rs.getString("microwave"));
			vo.setCloset(rs.getString("closet"));
			vo.setBed(rs.getString("bed"));
			vo.setInduction(rs.getString("induction"));
			vo.setShoeCabinet(rs.getString("shoecabinet"));
		}
		rs.close();
		stmt.close();

		return vo;
	}

	// 기본입력 인서트
	// 개인간거래테이블 조인 추가하기--------------------------------------------
	public void postInsert(PostRegistVO vo, String ids, String title, String text, String money) throws Exception {
		String id = ids;
		System.out.println("dao아이디:" + id);
		int customerNo = 0;
		int houseResidentCustomerNo = 0;
		int roomNumber = 0;
		// 기본입력 인서트
		String sql = "select c.customer_no, hrc.house_resident_customer_no, r.room_number " + "from area_sido asd, "
				+ "area_sigungu asg, " + "area_dong ad, " + "building b, " + "room r, " + "security_option so, "
				+ "basic_option bo, " + "house_resident_customer hrc, " + "customer c " + "where "
				+ "asd.area_sido_no=asg.area_sido_no " + "and asg.area_sigungu_no=ad.area_sigungu_no "
				+ "and ad.area_dong_no=b.area_dong_no " + "and so.building_no=b.building_no "
				+ "and b.building_no=r.building_no " + "and r.room_number=bo.room_number "
				+ "and r.room_number=hrc.room_number " + "and hrc.customer_no=c.customer_no " + "and c.customer_id='"
				+ id + "'";

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			customerNo = rs.getInt("customer_no");
			houseResidentCustomerNo = rs.getInt("house_resident_customer_no");
			roomNumber = rs.getInt("room_number");
		}
		rs.close();

		System.out.println("가구번호:" + roomNumber);

		// 부동산 사업자는 랜덤으로 가져오기

		// 랜덤으로 가져오기
		int count = 0;
		String sql2 = "select count(real_estate_dealer_no) a from real_estate_dealer";
		stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(sql2);
		if (rs2.next()) {
			count = rs2.getInt("a");
		}
		rs2.close();
		String posttitle = title;
		String posttext = text;
		String postmoney = money;
		int random = (int) (Math.random() * count + 1);
		System.out.println(random);
		System.out.println(random);
		System.out.println(random);
		System.out.println(random);
		String sql3 = "insert into personal_trade(personal_trade_no, house_resident_customer_no, real_estate_dealer_no, room_number, customer_no, posttitle, posttext, postmoney, postdate) "
				+ "values(personal_trade_no.nextval, ?, ?, ?, ? ,?, ?, ?, sysdate)";
		ps = con.prepareStatement(sql3);
		ps.getConnection().prepareStatement(sql3);
		ps.setInt(1, houseResidentCustomerNo);
		ps.setInt(2, customerNo);
		ps.setInt(3, random);
		ps.setInt(4, roomNumber);
		ps.setString(5, posttitle);
		ps.setString(6, posttext);
		ps.setString(7, postmoney);
		ps.executeUpdate();
		ps.close();

	}
}
