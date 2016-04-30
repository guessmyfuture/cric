package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "groundbooking")
public class GroundBookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId")
	private long bookingId;
	private long groundId;
	private Date dateOfPlay;
	@Transient
	String playingDate;
	private long slotId;
	private String status;
	private Date dateOfRequest;
	private long myTeam;
	private long opponentTeam;
	private long ballTypeId;
	private long bookedBy;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return bookingId;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.bookingId = id;
	}
	/**
	 * @return the groundId
	 */
	public long getGroundId() {
		return groundId;
	}
	/**
	 * @param groundId the groundId to set
	 */
	public void setGroundId(long groundId) {
		this.groundId = groundId;
	}
	/**
	
	/**
	 * @return the slotId
	 */
	public long getSlotId() {
		return slotId;
	}
	public Date getDateOfPlay() {
		return dateOfPlay;
	}
	public void setDateOfPlay(Date dateOfPlay) {
		this.dateOfPlay = dateOfPlay;
	}
	public String getPlayingDate() {
		return playingDate;
	}
	public void setPlayingDate(String playingDate) {
		this.playingDate = playingDate;
	}
	/**
	 * @param slotId the slotId to set
	 */
	public void setSlotId(long slotId) {
		this.slotId = slotId;
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
	 * @return the dateOfRequest
	 */
	public Date getDateOfRequest() {
		return dateOfRequest;
	}
	/**
	 * @param dateOfRequest the dateOfRequest to set
	 */
	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public long getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(long myTeam) {
		this.myTeam = myTeam;
	}
	public long getOpponentTeam() {
		return opponentTeam;
	}
	public void setOpponentTeam(long opponentTeam) {
		this.opponentTeam = opponentTeam;
	}
	/**
	 * @return the ballTypeId
	 */
	public long getBallTypeId() {
		return ballTypeId;
	}
	/**
	 * @param ballTypeId the ballTypeId to set
	 */
	public void setBallTypeId(long ballTypeId) {
		this.ballTypeId = ballTypeId;
	}
	/**
	 * @return the blockedBy
	 */
	public long getBookedBy() {
		return bookedBy;
	}
	/**
	 * @param blockedBy the blockedBy to set
	 */
	public void setBookedBy(long blockedBy) {
		this.bookedBy = blockedBy;
	}

}
