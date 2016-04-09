package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groundbooking")
public class GroundBookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId")
	private long bookingId;
	private long groundId;
	private Date date;
	private long slotId;
	private String status;
	private Date dateOfRequest;
	private long teamAId;
	private long teamBId;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the slotId
	 */
	public long getSlotId() {
		return slotId;
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
	/**
	 * @return the teamA
	 */
	public long getTeamAId() {
		return teamAId;
	}
	/**
	 * @param teamA the teamA to set
	 */
	public void setTeamAId(long teamA) {
		this.teamAId = teamA;
	}
	/**
	 * @return the teamB
	 */
	public long getTeamBId() {
		return teamBId;
	}
	/**
	 * @param teamB the teamB to set
	 */
	public void setTeamBId(long teamB) {
		this.teamBId = teamB;
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
