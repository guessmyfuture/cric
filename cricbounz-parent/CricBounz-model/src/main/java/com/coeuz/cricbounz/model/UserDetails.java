package com.coeuz.cricbounz.model;

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
	@Column(name="userId")
	private long id;
	private long authId;
	private String name;
	private String gender;
	private String phoneNo;
	private String address;
	private String email;
	private String mobile;
	private String state;
	private String city;
	private String area;
	private String bowling;
	private String batting;
	private String friends;
	private PostDetails postDetails;
	private CommentDetails commentDetails;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	

}
