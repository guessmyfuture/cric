package com.coeuz.cricbounz.model;

public class AbstractInnings {
	private long matchId;
	private long tosswonBy;
	public long getMatchId() {
		return matchId;
	}
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
	public long getTosswonBy() {
		return tosswonBy;
	}
	public void setTosswonBy(long tosswonBy) {
		this.tosswonBy = tosswonBy;
	}
	
	private long batting;
	private long bowling;
	public long getBatting() {
		return batting;
	}
	public void setBatting(long batting) {
		this.batting = batting;
	}
	public long getBowling() {
		return bowling;
	}
	public void setBowling(long bowling) {
		this.bowling = bowling;
	}

}
