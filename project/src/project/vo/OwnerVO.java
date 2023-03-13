package project.vo;

public class OwnerVO {
	String tel, ID, PW, name, buisness;
	private String address; 
	
	public OwnerVO() {
		
	}
	public OwnerVO(String tel, String ID, String PW, String name, String address, String buisness) {
		this.tel = tel;
		this.ID = ID;
		this.PW = PW;
		this.name = name;
		this.address = address;
		this.buisness = buisness;
		
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuisness() {
		return buisness;
	}
	public void setBuisness(String buisness) {
		this.buisness = buisness;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
