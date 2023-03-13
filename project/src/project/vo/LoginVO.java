package project.vo;

public class LoginVO {
	String ID, password;
	public LoginVO() {
		
	}
	public LoginVO(String id) {
		this.ID = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public LoginVO(String iD, String password) {
		this.ID = iD;
		this.password = password;
	}
}
