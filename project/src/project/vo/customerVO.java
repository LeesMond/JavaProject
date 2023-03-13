package project.vo;

public class customerVO {
	String tel, ID, PW, name, sex; 
	int age;

	public customerVO() {
	}

	public customerVO(String tel, String ID, String PW, String name, String sex, int age) { // String sex,
		this.tel = tel;
		this.ID = ID;
		this.PW = PW;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getId() {
		return ID;
	}

	public void setId(String ID) {
		this.ID = ID;
	}

	public String getPw() {
		return PW;
	}

	public void setPw(String PW) {
		this.PW = PW;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}