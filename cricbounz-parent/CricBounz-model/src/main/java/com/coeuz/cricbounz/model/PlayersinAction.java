package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "playersinaction")
@Component
public class PlayersinAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="playersinactionid")
	private long playersinactionid;
	private long teamid;
	private long playesrid;
	private long matchid;
	private long inningsid;
	/**
	 * @return the playersinactionid
	 */
	public long getPlayersinactionid() {
		return playersinactionid;
	}
	/**
	 * @param playersinactionid the playersinactionid to set
	 */
	public void setPlayersinactionid(long playersinactionid) {
		this.playersinactionid = playersinactionid;
	}
	/**
	 * @return the teamid
	 */
	public long getTeamid() {
		return teamid;
	}
	/**
	 * @param teamid the teamid to set
	 */
	public void setTeamid(long teamid) {
		this.teamid = teamid;
	}
	/**
	 * @return the playesrid
	 */
	public long getPlayesrid() {
		return playesrid;
	}
	/**
	 * @param playesrid the playesrid to set
	 */
	public void setPlayesrid(long playesrid) {
		this.playesrid = playesrid;
	}
	/**
	 * @return the matchid
	 */
	public long getMatchid() {
		return matchid;
	}
	/**
	 * @param matchid the matchid to set
	 */
	public void setMatchid(long matchid) {
		this.matchid = matchid;
	}
	/**
	 * @return the inningsid
	 */
	public long getInningsid() {
		return inningsid;
	}
	/**
	 * @param inningsid the inningsid to set
	 */
	public void setInningsid(long inningsid) {
		this.inningsid = inningsid;
	}
	

}
