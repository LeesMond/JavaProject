package project.vo;

public class realEstateDealRegistVO {
	String posttitle, posttype, posttext, postmoney, postaddress, postdaddress;

	//TRADE_NO,ROOM_NUMBER,CUSTOMER_NO,REAL_ESTATE_DEALER_NO,POSTTITLE,POSTTEXT,POSTDATE,POSTMONEY
	String ids;
	
public realEstateDealRegistVO(){}

	
	public realEstateDealRegistVO(String posttitle,String posttype,String posttext,String postmoney, String postaddress, String postdaddress, String ids){
		this.posttitle = posttitle;
		this.posttype = posttype;
		this.posttext = posttext;
		this.postmoney = postmoney;
		this.ids=ids;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}

	public String getPosttext() {
		return posttext;
	}

	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}

	public String getPostmoney() {
		return postmoney;
	}

	public void setPostmoney(String postmoney) {
		this.postmoney = postmoney;
	}
	
	public String getPostaddress() {
		return postaddress;
	}
	
	
	public void setPostaddress(String postaddress) {
		this.postaddress = postaddress;
	}
	
	
	public String getPostdaddress() {
		return postdaddress;
	}
	
	
	public void setPostdaddress(String postdaddress) {
		this.postdaddress = postdaddress;
	}
	
}
