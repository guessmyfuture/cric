package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "teamstatuschange")
@Component
public class TeamStatusChange {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="teamStatusChangeID")
	private long teamStatusChangeID;
	private long organizerID;
	private long tournamentId;
	private long teamId;
	private String status;
	
		
	public long getTeamStatusChangeID() {
		return teamStatusChangeID;
	}
	public void setTeamStatusChangeID(long teamStatusChangeID) {
		this.teamStatusChangeID = teamStatusChangeID;
	}
	
	public long getOrganizerID() {
		return organizerID;
	}
	public void setOrganizerID(long organizerID) {
		this.organizerID = organizerID;
	}
	
	public long getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
