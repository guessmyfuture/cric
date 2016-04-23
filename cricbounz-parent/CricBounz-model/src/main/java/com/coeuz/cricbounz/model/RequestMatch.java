package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "requestmatch")
public class RequestMatch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")	
	private long id;
	private boolean requestStatus;
	private String requestedBy;
	private long requestedForTeam ;
    private long requestedToTeam;
    private Date requestedDate;
    private long opponentTeamApprovalCount;
    private Date  matchDate;
    private int matchTime;
    private int matchEndTime;
    private boolean status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public long getRequestedForTeam() {
		return requestedForTeam;
	}
	public void setRequestedForTeam(long requestedForTeam) {
		this.requestedForTeam = requestedForTeam;
	}
	public long getRequestedToTeam() {
		return requestedToTeam;
	}
	public void setRequestedToTeam(long requestedToTeam) {
		this.requestedToTeam = requestedToTeam;
	}
	public Date getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}
	public long getOpponentTeamApprovalCount() {
		return opponentTeamApprovalCount;
	}
	public void setOpponentTeamApprovalCount(long opponentTeamApprovalCount) {
		this.opponentTeamApprovalCount = opponentTeamApprovalCount;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public int getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(int matchTime) {
		this.matchTime = matchTime;
	}
	public int getMatchEndTime() {
		return matchEndTime;
	}
	public void setMatchEndTime(int matchEndTime) {
		this.matchEndTime = matchEndTime;
	}
	public boolean getStatus() {
		return status;
	}
	public void setboolean(boolean status) {
		this.status = status;
	}
	
}