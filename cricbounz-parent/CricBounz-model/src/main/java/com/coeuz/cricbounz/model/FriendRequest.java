package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "friendrequestdetails")
@Component
public class FriendRequest {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fiendReqId")	
	private long fiendReqId;
	private String friendReqStatus;
	private long requestedByID;
	private long requestedTo;
	private Date requestedDate;
	private String status;
			
	/**
	 * @return the fiendReqId
	 */
	public long getFiendReqId() {
		return fiendReqId;
	}
	/**
	 * @param fiendReqId the fiendReqId to set
	 */
	public void setFiendReqId(long fiendReqId) {
		this.fiendReqId = fiendReqId;
	}
	/**
	 * @return the friendReqStatus
	 */
	public String getFriendReqStatus() {
		return friendReqStatus;
	}
	/**
	 * @param friendReqStatus the friendReqStatus to set
	 */
	public void setFriendReqStatus(String friendReqStatus) {
		this.friendReqStatus = friendReqStatus;
	}
	/**
	 * @return the requestedByID
	 */
	public long getRequestedByID() {
		return requestedByID;
	}
	/**
	 * @param requestedByID the requestedByID to set
	 */
	public void setRequestedByID(long requestedByID) {
		this.requestedByID = requestedByID;
	}
	/**
	 * @return the requestedTo
	 */
	public long getRequestedTo() {
		return requestedTo;
	}
	/**
	 * @param requestedTo the requestedTo to set
	 */
	public void setRequestedTo(long requestedTo) {
		this.requestedTo = requestedTo;
	}
	/**
	 * @return the requestedDate
	 */
	public Date getRequestedDate() {
		return requestedDate;
	}
	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
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
		
}
