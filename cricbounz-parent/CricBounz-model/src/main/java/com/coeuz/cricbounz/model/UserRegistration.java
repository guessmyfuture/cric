package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
public class UserRegistration {

@Id
private String username;

@Column(nullable=false)
private String password;

@Transient
private String mobileNumber;

private int enabled;


public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getEnabled() {
	return enabled;
}

public void setEnabled(int enabled) {
	this.enabled = enabled;
}

}
