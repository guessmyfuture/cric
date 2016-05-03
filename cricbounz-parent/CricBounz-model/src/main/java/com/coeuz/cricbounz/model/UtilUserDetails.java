package com.coeuz.cricbounz.model;

import java.util.Map;

public class UtilUserDetails {
	
	private long userID;
	private String userName;
	private String userImage;
	private Map<String,String> playesRoles;
	private String area;
	private String city;
	
	/**
	 * @return the playesRoles
	 */
	public Map<String, String> getPlayesRoles() {
		return playesRoles;
	}
	/**
	 * @param playesRoles the playesRoles to set
	 */
	public void setPlayesRoles(Map<String, String> playesRoles) {
		this.playesRoles = playesRoles;
	}
	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userImage
	 */
	public String getUserImage() {
		return userImage;
	}
	/**
	 * @param userImage the userImage to set
	 */
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	
	
	
	
}
