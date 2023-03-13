package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import project.vo.PostViewVO;

public class PostViewDAO {

	public PostViewDAO() throws Exception {
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
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}

	public PostViewVO postSelect(Number personalTradeNo) throws Exception {
		PostViewVO vo = new PostViewVO();
		String posttitle = vo.getPosttitle();
		String posttext = vo.getPosttext();
		String postmoney = vo.getPostmoney();
		String contractdate = vo.getContractdate();

		String sql = "select " + "r.detailed_addresss address, " + "c.customer_ID ID, " + "asd.area_sido_name sido,"
		// + "asg.area_sigungu_name sigungu,"
				+ "hrc.contract_date contractdate," + "pt.POSTMONEY, " + "b.building_type type, "
				+ "red.real_estate_name, " + "pt.posttitle, " + "pt.posttext, " + "pt.postmoney, " + "pt.postdate, "
				+ "so.cctv cctv, " + "so.window_gurad gurad, " + "so.interphone interphone, "
				+ "so.common_entrance entrance, " + "so.videophone videophone, " + "bo.air_conditioner airconditioner, "
				+ "bo.laundry laundry, " + "bo.internet internet, " + "bo.tv tv, " + "bo.refrigerator refrigerator, "
				+ "bo.microwave microwave, " + "bo.closet closet, " + "bo.bed bed, " + "bo.induction induction, "
				+ "bo.shoe_cabinet shoecabinet " + "from " + "room r," + "customer c," + "area_sido asd,"
				+ "area_sigungu asg," + "area_dong ad, " + "building b," + "security_option so," + "basic_option bo,"
				+ "house_resident_customer hrc, " + "personal_trade pt, " + "real_estate_dealer red " + "where "
				+ "asd.area_sido_no=asg.area_sido_no " + "and asg.area_sigungu_no=ad.area_sigungu_no "
				+ "and ad.area_dong_no=b.area_dong_no " + "and so.building_no=b.building_no "
				+ "and b.building_no=r.building_no " + "and r.room_number=hrc.room_number "
				+ "and c.customer_no=hrc.customer_no " + "and r.room_number=bo.room_number "
				+ "and c.customer_no=pt.customer_no " + "and red.real_estate_dealer_no = pt.real_estate_dealer_no "
				+ "and pt.personal_Trade_No= " + personalTradeNo;

		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setDetailedAddresss(rs.getString("address"));
			vo.setAreaSidoName(rs.getString("sido"));
			vo.setContractdate(rs.getString("contractdate"));
			vo.setBuildingType(rs.getString("type"));
			vo.setPosttitle(rs.getString("posttitle"));
			vo.setPosttext(rs.getString("posttext"));
			vo.setPostmoney(rs.getString("postmoney"));
			vo.setPostdate(rs.getDate("postdate"));
			vo.setPostcompany(rs.getString("real_estate_name"));
			vo.setCCTV(rs.getString("cctv"));
			vo.setWindowgurad(rs.getString("gurad"));
			vo.setInterphone(rs.getString("interphone"));
			vo.setCommonentrance(rs.getString("entrance"));
			vo.setVideophone(rs.getString("videophone"));
			vo.setAirconditioner(rs.getString("airconditioner"));
			vo.setLaundry(rs.getString("laundry"));
			vo.setInternet(rs.getString("internet"));
			vo.setTv(rs.getString("tv"));
			vo.setRefrigerator(rs.getString("refrigerator"));
			vo.setMicrowave(rs.getString("microwave"));
			vo.setCloset(rs.getString("closet"));
			vo.setBed(rs.getString("bed"));
			vo.setInduction(rs.getString("induction"));
			vo.setShoecabinet(rs.getString("shoecabinet"));
		}
		rs.close();
		stmt.close();

		return vo;
	}

	public void modify(PostViewVO vo, Number num) throws Exception {

		String posttitle = vo.getPosttitle();
		String posttext = vo.getPosttext();
		String postmoney = vo.getPostmoney();

		String sql = "update Personal_trade set posttitle=?, posttext=?, postmoney=? " + "where personal_trade_no = "
				+ num;
		ps = con.prepareStatement(sql);
		ps.setString(1, posttitle);
		ps.setString(2, posttext);
		ps.setString(3, postmoney);

		ps.executeUpdate();
		ps.close();

	}

	public void delete(PostViewVO vo, int num) throws Exception {

		int personalTradeNo = num;
		System.out.println(personalTradeNo);
		String posttitle = vo.getPosttitle();
		String posttype = vo.getBuildingType();
		String posttext = vo.getPosttext();
		String postaddr = vo.getAreaSidoName();
		String postdetailaddr = vo.getDetailedAddresss();
		String postmoney = vo.getPostmoney();
		String postcompany = vo.getPostcompany();

		String sql = "delete from Personal_trade where personal_trade_no=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, personalTradeNo);
		ps.executeUpdate();
		ps.close();
	}

	public String getID(int num) throws Exception {
		String sql = " select c.customer_id " + " from personal_trade pt, customer c " + " where personal_trade_no = "
				+ num + " " + " and c.customer_no = pt.customer_no";
		String ids = null;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ids = rs.getString("customer_id");
		}
		rs.close();
		stmt.close();
		return ids;
	}
}
