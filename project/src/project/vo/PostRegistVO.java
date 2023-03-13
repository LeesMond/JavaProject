package project.vo;

public class PostRegistVO {
	String postTitle, postText, areaSidoName, detailedAddresss, postMoney, realEstateName, buildingType, id, contractdate, postCompany;
	
	
	
	Number personalTradeNo;
	String postDate;
	String cctv, windowGurad, interPhone, commonEntrance, videoPhone, airConditioner, laundry, internet, tv, refrigerator, microwave, closet, bed, induction, shoeCabinet;
	
	
	public PostRegistVO() {}
	
	public PostRegistVO(String areaSidoName, String detailedAddresss, String contractdate, String buildingType, String cctv, String windowGurad, String interPhone, String commonEntrance, String videoPhone, String airConditioner, String laundry, String internet, String tv, String refrigerator, String microwave, String closet, String bed, String induction, String shoeCabinet) {
		this.areaSidoName=areaSidoName;
		this.detailedAddresss=detailedAddresss;
		this.contractdate=contractdate;
		this.buildingType=buildingType;
		
		this.cctv=cctv;
		this.windowGurad=windowGurad;
		this.interPhone=interPhone;
		this.commonEntrance=commonEntrance;
		this.videoPhone=videoPhone;
		this.airConditioner=airConditioner;
		this.laundry=laundry;
		this.internet=internet;
		this.tv=tv;
		this.refrigerator=refrigerator;
		this.microwave=microwave;
		this.closet=closet;
		this.bed=bed;
		this.induction=induction;
		this.shoeCabinet=shoeCabinet;
		
	}
	
	
	
	public PostRegistVO(Number personalTradeNo, String postTitle, String postText, String areaSidoName, String detailedAddresss, String postMoney, String realEstateName, String buildingType, String postDate, String cctv, String windowGurad, String interPhone, String commonEntrance, String videoPhone, String airConditioner, String laundry, String internet, String tv, String refrigerator, String microwave, String closet, String bed, String induction, String shoeCabinet) {
		
		this.personalTradeNo=personalTradeNo;
		this.postTitle=postTitle;
		this.postText=postText;
		this.areaSidoName=areaSidoName;
		this.detailedAddresss=detailedAddresss;
		this.postMoney=postMoney;
		this.realEstateName=realEstateName;
		this.buildingType=buildingType;
		this.postDate=postDate;
		
		this.cctv=cctv;
		this.windowGurad=windowGurad;
		this.interPhone=interPhone;
		this.commonEntrance=commonEntrance;
		this.videoPhone=videoPhone;
		this.airConditioner=airConditioner;
		this.laundry=laundry;
		this.internet=internet;
		this.tv=tv;
		this.refrigerator=refrigerator;
		this.microwave=microwave;
		this.closet=closet;
		this.bed=bed;
		this.induction=induction;
		this.shoeCabinet=shoeCabinet;
	}
	
	public PostRegistVO(Number personalTradeNo, String postTitle, String postText, String areaSidoName, String detailedAddresss, String postMoney, String realEstateName, String buildingType, String postDate) {
		this.personalTradeNo=personalTradeNo;
		this.postTitle=postTitle;
		this.postText=postText;
		this.areaSidoName=areaSidoName;
		this.detailedAddresss=detailedAddresss;
		this.postMoney=postMoney;
		this.realEstateName=realEstateName;
		this.buildingType=buildingType;
		this.postDate=postDate;
	}
	
	public PostRegistVO(String postTitle, String postText, String postMoney, String postDate) {
		this.postTitle=postTitle;
		this.postText=postText;
		this.postMoney=postMoney;
		
	}
	
	public PostRegistVO( String areaSidoName, String detailedAddresss, String realEstateName) {
		this.areaSidoName=areaSidoName;
		this.detailedAddresss=detailedAddresss;
		this.buildingType=buildingType;
	}
	
	public PostRegistVO(String cctv, String windowGurad, String interPhone, String commonEntrance, String videoPhone, String airConditioner, String laundry, String internet, String tv, String refrigerator, String microwave, String closet, String bed, String induction, String shoeCabinet) {
		this.cctv=cctv;
		this.windowGurad=windowGurad;
		this.interPhone=interPhone;
		this.commonEntrance=commonEntrance;
		this.videoPhone=videoPhone;
		this.airConditioner=airConditioner;
		this.laundry=laundry;
		this.internet=internet;
		this.tv=tv;
		this.refrigerator=refrigerator;
		this.microwave=microwave;
		this.closet=closet;
		this.bed=bed;
		this.induction=induction;
		this.shoeCabinet=shoeCabinet;
}
	public String getPostCompany() {
		return postCompany;
	}

	public void setPostCompany(String postCompany) {
		this.postCompany = postCompany;
	}
	
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
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
	public String getPostMoney() {
		return postMoney;
	}
	public void setPostMoney(String postMoney) {
		this.postMoney = postMoney;
	}
	public String getRealEstateName() {
		return realEstateName;
	}
	public void setRealEstateName(String realEstateName) {
		this.realEstateName = realEstateName;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public Number getPersonalTradeNo() {
		return personalTradeNo;
	}
	public void setPersonalTradeNo(Number personalTradeNo) {
		this.personalTradeNo = personalTradeNo;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getContractdate() {
		return contractdate;
	}

	public void setContractdate(String contractdate) {
		this.contractdate = contractdate;
	}
	
	public String getCctv() {
		return cctv;
	}
	public void setCctv(String cctv) {
		this.cctv = cctv;
	}
	public String getwindowGurad() {
		return windowGurad;
	}
	public void setwindowGurad(String windowGurad) {
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
	public void setCommonEntrance(String commonenTrance) {
		this.commonEntrance = commonenTrance;
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

	
}
	
