package mvcdemo.bean;

import java.io.Serializable;

public class StudentBean implements Serializable
{
  private String name;//姓名
  private String birth;//生日
  private String id;//身分證
  private String gender;//性別
  private String zipcode;//郵遞區號
  private String address;//地址
  private String phone;//電話
  private String mailaddress;//email
  
  public StudentBean()
  {
  }

public StudentBean(String namep, String birthp, String idp, String genderp, String zipcodep, String addressp, String phonep,
		String mailaddressp) {
	super();
	this.name = namep;
	this.birth = birthp;
	this.id = idp;
	this.gender = genderp;
	this.zipcode = zipcodep;
	this.address = addressp;
	this.phone = phonep;
	this.mailaddress = mailaddressp;
}

public String getName() {
	return name;
}

public void setName(String namep) {
	this.name = namep;
}

public String getBirth() {
	return birth;
}

public void setBirth(String birthp) {
	this.birth = birthp;
}

public String getId() {
	return id;
}

public void setId(String idp) {
	this.id = idp;
}

public String getGender() {
	return gender;
}

public void setGender(String genderp) {
	this.gender = genderp;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcodep) {
	this.zipcode = zipcodep;
}

public String getAddress() {
	return address;
}

public void setAddress(String addressp) {
	this.address = addressp;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phonep) {
	this.phone = phonep;
}

public String getMailaddress() {
	return mailaddress;
}

public void setMailaddress(String mailaddressp) {
	this.mailaddress = mailaddressp;
}
  
 

 

}