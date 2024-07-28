package model;

import java.sql.Date;
import java.util.List;

public class User {
	private int userid;
	private String userName;
	private String password;
	private String fullName;
	private String phoneNumber;
	private String address;
    private String email;
    private Date dateOfBirth;
    private int status;
    private byte[] img;
    private String roleName; 
    
	public User() {
		
	}


	


	public User(int userid, String userName, String password, String fullName, String phoneNumber, String address,
			String email, Date dateOfBirth, int status, byte[] img, String roleName) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
		this.img = img;
		this.roleName = roleName;
	}




	public int getUserid() {
		return userid;
	}





	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public byte[] getImg() {
		return img;
	}


	public void setImg(byte[] img) {
		this.img = img;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
