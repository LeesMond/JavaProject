package project.vo;



public class customer_mypage2VO {
String  id, pw, name, tel, sex, vehicle;
int age;


public customer_mypage2VO(String name, String tel, String sex, int age,String vehicle) {
	
	this.name = name;
	this.tel = tel;
	this.sex = sex;
	this.age = age;
	this.vehicle =vehicle;
	
	
}




public customer_mypage2VO(String id,String pw,String name, String tel, String sex, int age,String vehicle) {
	this.id = id;
	this.pw = pw;
	this.name = name;
	this.tel = tel;
	this.sex = sex;
	this.age = age;
	this.vehicle =vehicle;
	
	
}





public customer_mypage2VO() {
	// TODO Auto-generated constructor stub
}




public customer_mypage2VO(String name2, String tel2, String sex2, int age2, String vehicle2, String ids) {
	// TODO Auto-generated constructor stub
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

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getVehicle() {
	return vehicle;
}

public void setVehicle(String vehicle) {
	this.vehicle = vehicle;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

}


