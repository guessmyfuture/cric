package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Table(name = "matchrequest")
@Component
public class MatchRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="matchRequestID")	
	private long matchRequestID;
	private String requestStatus;
	private long requestedByID;
	private long requestedByTeam ;
    private long requestedToTeam;
    private Date requestedDate;
    private long opponentTeamApprovalCount;
    @Transient
    private String  transientmatchDate;
    private Date  matchDate;
    private String matchStartTime;
    private String matchEndTime;
    private String status;
    @Transient
    private long requestedToID;
	
    public String getTransientmatchDate() {
		return transientmatchDate;
	}
	public void setTransientmatchDate(String transientmatchDate) {
		this.transientmatchDate = transientmatchDate;
	}  
    
    /**
	 * @return the requestedToID
	 */
	public long getRequestedToID() {
		return requestedToID;
	}
	/**
	 * @param requestedToID the requestedToID to set
	 */
	public void setRequestedToID(long requestedToID) {
		this.requestedToID = requestedToID;
	}
	/**
	 * @return the matchRequestID
	 */
	public long getMatchRequestID() {
		return matchRequestID;
	}
	/**
	 * @param matchRequestID the matchRequestID to set
	 */
	public void setMatchRequestID(long matchRequestID) {
		this.matchRequestID = matchRequestID;
	}
	/**
	 * @return the requestStatus
	 */
	public String getRequestStatus() {
		return requestStatus;
	}
	/**
	 * @param requestStatus the requestStatus to set
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	/**
	 * @return the requestedByID
	 */
	public long getRequestedByID() {
		return requestedByID;
	}
	/**
	 * @param requestedByID the requestedByID to set
	 */
	public void setRequestedByID(long requestedByID) {
		this.requestedByID = requestedByID;
	}
	/**
	 * @return the requestedByTeam
	 */
	public long getRequestedByTeam() {
		return requestedByTeam;
	}
	/**
	 * @param requestedByTeam the requestedByTeam to set
	 */
	public void setRequestedByTeam(long requestedByTeam) {
		this.requestedByTeam = requestedByTeam;
	}
	/**
	 * @return the requestedToTeam
	 */
	public long getRequestedToTeam() {
		return requestedToTeam;
	}
	/**
	 * @param requestedToTeam the requestedToTeam to set
	 */
	public void setRequestedToTeam(long requestedToTeam) {
		this.requestedToTeam = requestedToTeam;
	}
	/**
	 * @return the requestedDate
	 */
	public Date getRequestedDate() {
		return requestedDate;
	}
	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}
	/**
	 * @return the opponentTeamApprovalCount
	 */
	public long getOpponentTeamApprovalCount() {
		return opponentTeamApprovalCount;
	}
	/**
	 * @param opponentTeamApprovalCount the opponentTeamApprovalCount to set
	 */
	public void setOpponentTeamApprovalCount(long opponentTeamApprovalCount) {
		this.opponentTeamApprovalCount = opponentTeamApprovalCount;
	}
	/**
	 * @return the matchDate
	 */
	public Date getMatchDate() {
		return matchDate;
	}
	/**
	 * @param matchDate the matchDate to set
	 */
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	/**
	 * @return the matchStartTime
	 */
	public String getMatchStartTime() {
		return matchStartTime;
	}
	/**
	 * @param matchStartTime the matchStartTime to set
	 */
	public void setMatchStartTime(String matchStartTime) {
		this.matchStartTime = matchStartTime;
	}
	/**
	 * @return the matchEndTime
	 */
	public String getMatchEndTime() {
		return matchEndTime;
	}
	/**
	 * @param matchEndTime the matchEndTime to set
	 */
	public void setMatchEndTime(String matchEndTime) {
		this.matchEndTime = matchEndTime;
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

		
}