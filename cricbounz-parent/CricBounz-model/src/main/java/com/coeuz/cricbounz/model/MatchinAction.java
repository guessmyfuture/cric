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
public class MatchinAction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="matchinactionID")
	private long matchinactionID;
	private long matchID;
	private long teamAID;
	private long teamBID;
	/**
	 * @return the matchinactionID
	 */
	public long getMatchinactionID() {
		return matchinactionID;
	}
	/**
	 * @param matchinactionID the matchinactionID to set
	 */
	public void setMatchinactionID(long matchinactionID) {
		this.matchinactionID = matchinactionID;
	}
	/**
	 * @return the matchID
	 */
	public long getMatchID() {
		return matchID;
	}
	/**
	 * @param matchID the matchID to set
	 */
	public void setMatchID(long matchID) {
		this.matchID = matchID;
	}
	/**
	 * @return the teamAID
	 */
	public long getTeamAID() {
		return teamAID;
	}
	/**
	 * @param teamAID the teamAID to set
	 */
	public void setTeamAID(long teamAID) {
		this.teamAID = teamAID;
	}
	/**
	 * @return the teamBID
	 */
	public long getTeamBID() {
		return teamBID;
	}
	/**
	 * @param teamBID the teamBID to set
	 */
	public void setTeamBID(long teamBID) {
		this.teamBID = teamBID;
	}
	
}
