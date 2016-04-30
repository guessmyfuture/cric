package com.coeuz.cricbounz.model;

import java.util.Date;

public class GroundBookingHistory {
	private long bookingId;
	private long groundId;
	private long myTeamId;
	private String myTeam;
	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	private long opponentTeamId;
	private Date dateOfPlay;

	public GroundBookingHistory(long bookingId, long groundId, long myTeamId, long opponentTeamId, Date dateOfPlay,
			Date dateOfRequest, String groundName, String area, String city, String ballType, String opponent) {
		this.bookingId = bookingId;
		this.groundId = groundId;
		this.myTeamId = myTeamId;
		this.opponentTeamId = opponentTeamId;
		this.dateOfPlay = dateOfPlay;
		this.dateOfRequest = dateOfRequest;
		this.groundName = groundName;
		this.area = area;
		this.city = city;
		this.ballType = ballType;
		this.opponent = opponent;
	}

	public GroundBookingHistory() {
	}

	private Date dateOfRequest;
	private String groundName;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getGroundId() {
		return groundId;
	}

	public void setGroundId(long groundId) {
		this.groundId = groundId;
	}

	public long getMyTeamId() {
		return myTeamId;
	}

	public void setMyTeamId(long myTeamId) {
		this.myTeamId = myTeamId;
	}

	public long getOpponentTeamId() {
		return opponentTeamId;
	}

	public void setOpponentTeamId(long opponentTeamId) {
		this.opponentTeamId = opponentTeamId;
	}

	public Date getDateOfPlay() {
		return dateOfPlay;
	}

	public void setDateOfPlay(Date dateOfPlay) {
		this.dateOfPlay = dateOfPlay;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBallType() {
		return ballType;
	}

	public void setBallType(String ballType) {
		this.ballType = ballType;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	private String area;
	private String city;
	private String ballType;
	private String opponent;

}
