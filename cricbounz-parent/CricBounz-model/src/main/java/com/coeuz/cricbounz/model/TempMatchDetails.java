package com.coeuz.cricbounz.model;

import java.math.BigInteger;
import java.util.Date;

public class TempMatchDetails {

	private BigInteger teamAID;
	private BigInteger teamBID;
	private BigInteger matchId;
	public BigInteger getTeamAID() {
		return teamAID;
	}
	public void setTeamAID(BigInteger teamAID) {
		this.teamAID = teamAID;
	}
	public BigInteger getTeamBID() {
		return teamBID;
	}
	public void setTeamBID(BigInteger teamBID) {
		this.teamBID = teamBID;
	}
	public BigInteger getMatchId() {
		return matchId;
	}
	public void setMatchId(BigInteger matchId) {
		this.matchId = matchId;
	}
	public String getTeamAName() {
		return teamAName;
	}
	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}
	public String getTeamBName() {
		return teamBName;
	}
	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
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
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPlayingDate() {
		return playingDate;
	}
	public void setPlayingDate(Date playingDate) {
		this.playingDate = playingDate;
	}
	public String getTournamentName() {
		return tournamentName;
	}
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}


	private String teamAName;
	private String teamBName;
	private String city;
	private String area;
	private String venue;
	private String status;
	private Date playingDate;
	private int overs;
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	
	
	private String tournamentName;
	private String matchType;
	private int slot;
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	
		
}
