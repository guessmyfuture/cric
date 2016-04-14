package com.coeuz.cricbounz.model;

public class LikedUserDetails {
	
	private long userID;
	private String userName;
	private String likedUserImage;
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLikedUserImage() {
		return likedUserImage;
	}
	public void setLikedUserImage(String likedUserImage) {
		this.likedUserImage = likedUserImage;
	}
	
}
