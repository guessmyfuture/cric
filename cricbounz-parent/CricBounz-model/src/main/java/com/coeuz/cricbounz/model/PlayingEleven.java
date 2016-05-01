package com.coeuz.cricbounz.model;

public class PlayingEleven {
	
	private long teamId;
	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	private long[] players;

	public long[] getPlayers() {
		return players;
	}

	public void setPlayers(long[] players) {
		this.players = players;
	}

}
