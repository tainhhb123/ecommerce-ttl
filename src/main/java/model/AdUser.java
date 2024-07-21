package model;

import java.sql.Date;

public class AdUser {
	 private String fullName;
	    private String userName;
	    private String email;
	    private String phoneNumber;
	    private Date dateOfBirth;
	    private int status;

	    public AdUser() {
	       
	    }

	    public AdUser(String fullName, String userName, String email, String phoneNumber, Date dateOfBirth, int status) {
	        super();
	        this.fullName = fullName;
	        this.userName = userName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.dateOfBirth = dateOfBirth;
	        this.status = status;
	    }

	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
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
}
