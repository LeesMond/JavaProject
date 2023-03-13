package project.vo;

import java.sql.Date;

public class PostViewVO {
	String posttitle,buildingType, posttext, areaSidoName, detailedAddresss, postmoney, postcompany, contractdate, Id;
	
	
	Date postdate;
	Number personalTradeNo;
	String CCTV, windowgurad, interphone, commonentrance, videophone, airconditioner, laundry, internet, tv, refrigerator, microwave, closet, bed, induction, shoecabinet;

	public PostViewVO() {}
	public PostViewVO(String posttitle, String posttext, String areaSidoName, String detailedAddresss, String postmoney, String postcompany, String BuildingType, String contractdate) {
		this.posttitle=posttitle;
		this.buildingType=BuildingType;
		this.posttext=posttext;
		this.areaSidoName=areaSidoName;
		this.detailedAddresss=detailedAddresss;
		this.postmoney=postmoney;
		this.postcompany=postcompany;
		this.contractdate=contractdate;
	}
	
	public PostViewVO( String posttitle, String posttext, String postmoney) {
	
		this.posttitle=posttitle;
		this.posttext=posttext;
		this.postmoney=postmoney;
	}
	
	public PostViewVO(Number persionaltradeOptionNo, String CCTV, String windowgurad, String interphone, String commonentrance, String videophone, String airconditioner, String laundry, String internet, String tv, String refrigerator, String microwave, String closet, String bed, String induction, String shoecabinet) {
		this.CCTV=CCTV;
		this.windowgurad=windowgurad;
		this.interphone=interphone;
		this.commonentrance=commonentrance;
		this.videophone=videophone;
		this.airconditioner=airconditioner;
		this.laundry=laundry;
		this.internet=internet;
		this.tv=tv;
		this.refrigerator=refrigerator;
		this.microwave=microwave;
		this.closet=closet;
		this.bed=bed;
		this.induction=induction;
		this.shoecabinet=shoecabinet;

	}
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getPosttext() {
		return posttext;
	}
	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}
	public String getAreaSidoName() {
		return areaSidoName;
	}
	public void setAreaSidoName(String areaSidoName) {
		this.areaSidoName = areaSidoName;
	}
	public String getDetailedAddresss() {
		return detailedAddresss;
	}
	public void setDetailedAddresss(String detailedAddresss) {
		this.detailedAddresss = detailedAddresss;
	}
	public String getPostmoney() {
		return postmoney;
	}
	public void setPostmoney(String postmoney) {
		this.postmoney = postmoney;
	}
	public String getPostcompany() {
		return postcompany;
	}
	public void setPostcompany(String postcompany) {
		this.postcompany = postcompany;
	}
	public Number getpersonalTradeNo() {
		return  personalTradeNo;
	}
	public void setPostno(Number  personalTradeNo) {
		this. personalTradeNo =  personalTradeNo;
	}
	public String getContractdate() {
		return contractdate;
	}
	public void setContractdate(String contractdate) {
		this.contractdate = contractdate;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Number getPersonalTradeNo() {
		return personalTradeNo;
	}
	public void setPersonalTradeNo(Number personalTradeNo) {
		this.personalTradeNo = personalTradeNo;
	}
	public String getCCTV() {
		return CCTV;
	}
	public void setCCTV(String Cctv) {
		CCTV = Cctv;
	}
	public String getWindowgurad() {
		return windowgurad;
	}
	public void setWindowgurad(String windowgurad) {
		this.windowgurad = windowgurad;
	}
	public String getInterphone() {
		return interphone;
	}
	public void setInterphone(String interphone) {
		this.interphone = interphone;
	}
	public String getCommonentrance() {
		return commonentrance;
	}
	public void setCommonentrance(String commonentrance) {
		this.commonentrance = commonentrance;
	}
	public String getVideophone() {
		return videophone;
	}
	public void setVideophone(String videophone) {
		this.videophone = videophone;
	}
	public String getAirconditioner() {
		return airconditioner;
	}
	public void setAirconditioner(String airconditioner) {
		this.airconditioner = airconditioner;
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
	public String getShoecabinet() {
		return shoecabinet;
	}
	public void setShoecabinet(String shoecabinet) {
		this.shoecabinet = shoecabinet;
	}
}
	