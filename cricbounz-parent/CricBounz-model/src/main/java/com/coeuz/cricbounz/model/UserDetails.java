package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "userdetails")
@Component
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private long userId;
	private long authId;
	private String name;
	private String profileImageUrl;
	private String gender;
	private String phoneNo;
	private String address;
	private String profileName;
	private Date dob;
	private String battingStyle;
	private String bowlingStyle;
	private String bowlingType;

	@Column(name = "email", unique = true)
	private String email;
	
	private String mobile;
	private String state;
	private String city;
	private String area;
	private String bowling;
	private String batting;
	private String friends;
	private String status;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAuthId() {
		return authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	

	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	
	/**
	 * @return the battingStyle
	 */
	public String getBattingStyle() {
		return battingStyle;
	}

	/**
	 * @param battingStyle the battingStyle to set
	 */
	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}

	/**
	 * @return the bowlingStyle
	 */
	public String getBowlingStyle() {
		return bowlingStyle;
	}

	/**
	 * @param bowlingStyle the bowlingStyle to set
	 */
	public void setBowlingStyle(String bowlingStyle) {
		this.bowlingStyle = bowlingStyle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBowling() {
		return bowling;
	}

	public void setBowling(String bowling) {
		this.bowling = bowling;
	}

	public String getBatting() {
		return batting;
	}

	public void setBatting(String batting) {
		this.batting = batting;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the bowlingType
	 */
	public String getBowlingType() {
		return bowlingType;
	}

	/**
	 * @param bowlingType the bowlingType to set
	 */
	public void setBowlingType(String bowlingType) {
		this.bowlingType = bowlingType;
	}
	
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}



}
