package project.vo;

import java.util.ArrayList;

public class realEstateDeal2VO {
	//번호 작성자 지역 종류
	int tradeno;
	String posttitle,posttext,postname;
	String ids;
	String sidoname;
	
	String  areaSidoName, detailAddresss, buildingType, cctv, windowGurad, interPhone, commonEntrance, videoPhone, airConditioner, laundry, internet, tv, refrigerator, microwave, closet, bed, induction, shoeCabinet;
	Number personalTradeNo;
	

	public realEstateDeal2VO() {}
	
	public realEstateDeal2VO(String ids) {
		this.ids=ids;
	}

	
	public realEstateDeal2VO(int tradeno, String posttitle,String posttext,String postname, String ids) {
		this.tradeno=tradeno;
		this.posttitle=posttitle;
		this.posttext=posttext;
		this.postname=postname;
		this.ids=ids;
	}
	
	public int getTradeno() {
		return tradeno;
	}

	public void setTradeno(int tradeno) {
		this.tradeno = tradeno;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPosttext() {
		return posttext;
	}

	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}
	
	
	//
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSidoname() {
		return sidoname;
	}

	public void setSidoname(String sidoname) {
		this.sidoname = sidoname;
	}

	public String getAreaSidoName() {
		return areaSidoName;
	}

	public void setAreaSidoName(String areaSidoName) {
		this.areaSidoName = areaSidoName;
	}

	public String getDetailAddresss() {
		return detailAddresss;
	}

	public void setDetailAddresss(String detailAddresss) {
		this.detailAddresss = detailAddresss;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getCctv() {
		return cctv;
	}

	public void setCctv(String cctv) {
		this.cctv = cctv;
	}

	public String getWindowGurad() {
		return windowGurad;
	}

	public void setWindowGurad(String windowGurad) {
		this.windowGurad = windowGurad;
	}

	public String getInterPhone() {
		return interPhone;
	}

	public void setInterPhone(String interPhone) {
		this.interPhone = interPhone;
	}

	public String getCommonEntrance() {
		return commonEntrance;
	}

	public void setCommonEntrance(String commonEntrance) {
		this.commonEntrance = commonEntrance;
	}

	public String getVideoPhone() {
		return videoPhone;
	}

	public void setVideoPhone(String videoPhone) {
		this.videoPhone = videoPhone;
	}

	public String getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}

	public String getLaundry() {
		return laundry;
	}

	public void setLaundry(String laundry) {
		this.laundry = laundry;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getRefrigerator() {
		return refrigerator;
	}

	public void setRefrigerator(String refrigerator) {
		this.refrigerator = refrigerator;
	}

	public String getMicrowave() {
		return microwave;
	}

	public void setMicrowave(String microwave) {
		this.microwave = microwave;
	}

	public String getCloset() {
		return closet;
	}

	public void setCloset(String closet) {
		this.closet = closet;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getInduction() {
		return induction;
	}

	public void setInduction(String induction) {
		this.induction = induction;
	}

	public String getShoeCabinet() {
		return shoeCabinet;
	}

	public void setShoeCabinet(String shoeCabinet) {
		this.shoeCabinet = shoeCabinet;
	}

	public Number getPersonalTradeNo() {
		return personalTradeNo;
	}

	public void setPersonalTradeNo(Number personalTradeNo) {
		this.personalTradeNo = personalTradeNo;
	}

}
