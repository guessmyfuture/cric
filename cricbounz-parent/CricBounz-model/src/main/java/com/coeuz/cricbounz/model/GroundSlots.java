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
@Table(name = "groundslots")
public class GroundSlots {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "slotId")
	private long slotId;
	private long groundId;
	private String slotStartTime;
	private String slotEndTime;
	private int status;
	private Date bookedDate;
	@Transient
	private long teamAId;
	@Transient
	private long bookedBy;
	
	/**
	 * @return the teamAId
	 */
	public long getTeamAId() {
		return teamAId;
	}

	/**
	 * @param teamAId the teamAId to set
	 */
	public void setTeamAId(long teamAId) {
		this.teamAId = teamAId;
	}

	/**
	 * @return the bookedBy
	 */
	public long getBookedBy() {
		return bookedBy;
	}

	/**
	 * @param bookedBy the bookedBy to set
	 */
	public void setBookedBy(long bookedBy) {
		this.bookedBy = bookedBy;
	}

	/**
	 * @return the bookedDate
	 */
	public Date getBookedDate() {
		return bookedDate;
	}

	/**
	 * @param bookedDate
	 *            the bookedDate to set
	 */
	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public long getSlotId() {
		return slotId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setSlotId(long id) {
		this.slotId = id;
	}

	/**
	 * @return the groundId
	 */
	public long getGroundId() {
		return groundId;
	}

	/**
	 * @param groundId
	 *            the groundId to set
	 */
	public void setGroundId(long groundId) {
		this.groundId = groundId;
	}

	/**
	 * @return the slotStartTime
	 */
	public String getSlotStartTime() {
		return slotStartTime;
	}

	/**
	 * @param slotStartTime
	 *            the slotStartTime to set
	 */
	public void setSlotStartTime(String slotStartTime) {
		this.slotStartTime = slotStartTime;
	}

	/**
	 * @return the slotEndTime
	 */
	public String getSlotEndTime() {
		return slotEndTime;
	}

	/**
	 * @param slotEndTime
	 *            the slotEndTime to set
	 */
	public void setSlotEndTime(String slotEndTime) {
		this.slotEndTime = slotEndTime;
	}

}
