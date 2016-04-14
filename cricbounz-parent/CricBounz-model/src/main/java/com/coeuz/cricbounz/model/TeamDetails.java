package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String caption;
	private String contactno;
	private String players;
	private String balltype;
	private String managers;
	private String pitchtype;
	private String followersuid;
	private String pid;
	private String status;
	
	
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
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}
	public String getBalltype() {
		return balltype;
	}
	public void setBalltype(String balltype) {
		this.balltype = balltype;
	}
	public String getManagers() {
		return managers;
	}
	public void setManagers(String managers) {
		this.managers = managers;
	}
	public String getPitchtype() {
		return pitchtype;
	}
	public void setPitchtype(String pitchtype) {
		this.pitchtype = pitchtype;
	}
	public String getFollowersuid() {
		return followersuid;
	}
	public void setFollowersuid(String followersuid) {
		this.followersuid = followersuid;
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
	

}
