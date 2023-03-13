package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.rowset.OracleRowSetListenerAdapter;
import project.vo.realEstateDealViewVO;

public class realEstateDealViewDAO {

	public realEstateDealViewDAO() throws Exception {
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

	public realEstateDealViewVO postSelect(int num) throws Exception {
		
		String sql = "select"
				+ "	t.posttitle, "
				+ "	t.posttext, "
				+ "	t.postmoney, "
				+ "	bo.AIR_CONDITIONER, "
				+ "	bo.LAUNDRY, "
				+ "	bo.INTERNET, "
				+ "	bo.TV, "
				+ "	bo.REFRIGERATOR, "
				+ "	bo.MICROWAVE, "
				+ "	bo.CLOSET, "
				+ "	bo.BED, "
				+ "	bo.INDUCTION, "
				+ "	bo.SHOE_CABINET, "
				+ "	so.CCTV, "
				+ "	so.WINDOW_GURAD, "
				+ "	so.INTERPHONE, "
				+ "	so.COMMON_ENTRANCE, "
				+ "	so.VIDEOPHONE, "
				+ "	red.real_estate_name, "
				+ "	ad.area_dong_name, "
				+ "	asi.area_sido_name, "
				+ "	b.building_type "
				+ " from "
				+ "	trade t, "
				+ "	room r, "
				+ "	basic_option bo, "
				+ "	building b, "
				+ "	security_option so, "
				+ "	real_estate_dealer red, "
				+ "	area_dong ad, "
				+ "	area_sigungu asg, "
				+ "	area_sido asi "
				+ " where "
				+ "	t.room_number = r.room_number "
				+ "	and bo.room_number = r.room_number "
				+ "	and r.building_no = b.building_no "
				+ "	and b.building_no = so.building_no "
				+ "	and t.real_estate_dealer_no = red.real_estate_dealer_no "
				+ "	and b.area_dong_no = ad.area_dong_no "
				+ "	and ad.area_sigungu_no = asg.area_sigungu_no "
				+ "	and asg.area_sido_no = asi.area_sido_no "
				+ "	and t.trade_no = "+num;

		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		realEstateDealViewVO vo = new realEstateDealViewVO();
		if (rs.next()) {
			vo.setPosttitle(rs.getString("posttitle"));
			vo.setPosttext(rs.getString("posttext"));
			vo.setPostmoney(rs.getString("postmoney"));
			vo.setAIR_CONDITIONER(rs.getString("AIR_CONDITIONER"));
			vo.setLAUNDRY(rs.getString("LAUNDRY"));
			vo.setINTERNET(rs.getString("INTERNET"));
			vo.setTV(rs.getString("TV"));
			vo.setREFRIGERATOR(rs.getString("REFRIGERATOR"));
			vo.setMICROWAVE(rs.getString("MICROWAVE"));
			vo.setCLOSET(rs.getString("CLOSET"));
			vo.setBED(rs.getString("BED"));
			vo.setINDUCTION(rs.getString("INDUCTION"));
			vo.setSHOE_CABINET(rs.getString("SHOE_CABINET"));
			vo.setCCTV(rs.getString("CCTV"));
			vo.setWINDOW_GURAD(rs.getString("WINDOW_GURAD"));
			vo.setINTERPHONE(rs.getString("INTERPHONE"));
			vo.setCOMMON_ENTRANCE(rs.getString("COMMON_ENTRANCE"));
			vo.setVIDEOPHONE(rs.getString("VIDEOPHONE"));
			vo.setReal_estate_name(rs.getString("real_estate_name"));
			vo.setArea_dong_name(rs.getString("area_dong_name"));
			vo.setArea_sido_name(rs.getString("area_sido_name"));
			vo.setBuilding_type(rs.getString("building_type"));
		}
		rs.close();
		stmt.close();
		return vo;
	}

	public void modify(realEstateDealViewVO vo, Number num) throws Exception {

		String posttitle = vo.getPosttitle();
		String posttext = vo.getPosttext();
		String postmoney = vo.getPostmoney();

		String sql = "update trade set posttitle=?, posttext=?, postmoney=? " + "where trade_no = "
				+ num;
		ps = con.prepareStatement(sql);
		ps.setString(1, posttitle);
		ps.setString(2, posttext);
		ps.setString(3, postmoney);
		ps.executeUpdate();
		ps.close();

	}

	public void delete(int num) throws Exception {
		int personalTradeNo = num;

		String sql = "delete from trade where trade_no=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, personalTradeNo);
		ps.executeUpdate();
		ps.close();
	}

	public String getID(int num) throws Exception {
		String sql = "  select bo.building_owner_id "
				+ " from building_owner bo, trade t "
				+ " where t.building_owner_no = bo.building_owner_no and trade_no = "+num;
		String ids = null;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ids = rs.getString("building_owner_id");
		}
		rs.close();
		stmt.close();
		return ids;
	}
}
