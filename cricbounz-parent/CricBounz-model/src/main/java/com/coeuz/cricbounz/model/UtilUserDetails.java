package com.coeuz.cricbounz.model;

import java.util.Map;

public class UtilUserDetails {
	
	private long userID;
	private String userName;
	private String userImage;
	private Map playesRoles;
	
	/**
	 * @return the playesRoles
	 */
	public Map getPlayesRoles() {
		return playesRoles;
	}
	/**
	 * @param playesRoles the playesRoles to set
	 */
	public void setPlayesRoles(Map playesRoles) {
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
	
	
}
