package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "matchdetails")
public class MatchDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="matchID")	
	private long matchID;
	private long teamAId;
	private long teamBId;
	private String venue;
	private String status;
	private Date  timestamp;
	private String wonBy;
	private String umpire1;
	private String umpire2;
	private String ballType;
	private String scorer;
	private String pitchType;
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
	 * @return the teamAId
	 */
	public long getTeamAId() {
		return teamAId;
	}
	/**
	 * @param teamAId the teamAId to set
	 */
	public void setTeamAId(long teamAId) {
		this.teamAId = teamAId;
	}
	/**
	 * @return the teamBId
	 */
	public long getTeamBId() {
		return teamBId;
	}
	/**
	 * @param teamBId the teamBId to set
	 */
	public void setTeamBId(long teamBId) {
		this.teamBId = teamBId;
	}
	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the wonBy
	 */
	public String getWonBy() {
		return wonBy;
	}
	/**
	 * @param wonBy the wonBy to set
	 */
	public void setWonBy(String wonBy) {
		this.wonBy = wonBy;
	}
	/**
	 * @return the umpire1
	 */
	public String getUmpire1() {
		return umpire1;
	}
	/**
	 * @param umpire1 the umpire1 to set
	 */
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	/**
	 * @return the umpire2
	 */
	public String getUmpire2() {
		return umpire2;
	}
	/**
	 * @param umpire2 the umpire2 to set
	 */
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
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
	 * @return the scorer
	 */
	public String getScorer() {
		return scorer;
	}
	/**
	 * @param scorer the scorer to set
	 */
	public void setScorer(String scorer) {
		this.scorer = scorer;
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
		

}
