package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "livematch")
@Component
public class MatchinAction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="matchinactionID")
	private long matchinactionID;
	@Column(unique=true)
	private long matchID;
	@Column(unique=true)
	private long teamAID;
	@Column(unique=true)
	private long teamBID;
	@Column(unique=true)
	
	
	/**
	 * @return the matchinactionID
	 */
	public long getMatchinactionID() {
		return matchinactionID;
	}
	public long getTeamAID() {
		return teamAID;
	}
	public void setTeamAID(long teamAID) {
		this.teamAID = teamAID;
	}
	public long getTeamBID() {
		return teamBID;
	}
	public void setTeamBID(long teamBID) {
		this.teamBID = teamBID;
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
}
