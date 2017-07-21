package com.pos.beans;

import java.util.Date;




public class User {

	private Long id;
	private String userName;
	private String password;
	private String cnic;
	private String userMobileNo;
	private String address;
	private String is_active;
	private Date last_successful_login;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	
	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	public Date getLast_successful_login() {
		return last_successful_login;
	}

	public void setLast_successful_login(Date last_successful_login) {
		this.last_successful_login = last_successful_login;
	}

}
