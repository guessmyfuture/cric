package com.coeuz.cricbounz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "teamdetails")
@Component
public class TeamDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="teamID")
	private long teamID;
	private String name;
	private String city;
	private String area;
	private long captain;
	private String contactNo;
	private String players;
	private String ballType;
	private long managers;
	private String pitchType;
	private String followersUid;
	private String pid;
	private String description;	
	private String status;
	
	@Transient
	List<UtilUserDetails> playesDetailsList;
		
	/**
	 * @return the playesDetailsList
	 */
	public List<UtilUserDetails> getPlayesDetailsList() {
		return playesDetailsList;
	}
	/**
	 * @param playesDetailsList the playesDetailsList to set
	 */
	public void setPlayesDetailsList(List<UtilUserDetails> playesDetailsList) {
		this.playesDetailsList = playesDetailsList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}

	public long getManagers() {
		return managers;
	}
	public void setManagers(long managers) {
		this.managers = managers;
	}

	
	/**
	 * @return the ballType
	 */
	public String getBallType() {
		return ballType;
	}
	/**
	 * @param ballType the ballType to set
	 */
	public void setBallType(String ballType) {
		this.ballType = ballType;
	}
	/**
	 * @return the pitchType
	 */
	public String getPitchType() {
		return pitchType;
	}
	/**
	 * @param pitchType the pitchType to set
	 */
	public void setPitchType(String pitchType) {
		this.pitchType = pitchType;
	}
	/**
	 * @return the followersUid
	 */
	public String getFollowersUid() {
		return followersUid;
	}
	/**
	 * @param followersUid the followersUid to set
	 */
	public void setFollowersUid(String followersUid) {
		this.followersUid = followersUid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	/**
	 * @return the captain
	 */
	public long getCaptain() {
		return captain;
	}
	/**
	 * @param captain the captain to set
	 */
	public void setCaptain(long captain) {
		this.captain = captain;
	}
	/**
	 * @return the teamID
	 */
	public long getTeamID() {
		return teamID;
	}
	/**
	 * @param teamID the teamID to set
	 */
	public void setTeamID(long teamID) {
		this.teamID = teamID;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
