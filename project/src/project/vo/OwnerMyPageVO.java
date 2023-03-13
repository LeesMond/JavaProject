package project.vo;

public class OwnerMyPageVO {
	String id, pw, name, tel, addr, businessNum;
	
	public OwnerMyPageVO() {
		
	}
	
	public OwnerMyPageVO(String id, String pw, String name, String tel, String addr, String businessNum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.businessNum = businessNum;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
}
