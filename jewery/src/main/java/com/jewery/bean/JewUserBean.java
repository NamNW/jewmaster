package com.jewery.bean;

import java.io.Serializable;
import java.util.Date;

public class JewUserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5547460090798346979L;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
