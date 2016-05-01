package com.coeuz.cricbounz.model;

public class LiveMatches {
	
	private long matchID;
	private long teamAID;
	private long teamBID;
	
	private String teamAName;
	private String teamBName;
	public long getMatchID() {
		return matchID;
	}
	public void setMatchID(long matchID) {
		this.matchID = matchID;
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

}
