package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "requestnotifications")
@Component
public class RequestNotifications {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reqNotificationID")	
	private long reqNotificationID;
	private String requestType;
	private String requestStatus;
	private long notifyToID;
	private long requestID;
	private Date  timeStamp;
	@Transient
	private UtilUserDetails utilUserDetails;
	
	/**
	 * @return the reqNotificationID
	 */
	public long getReqNotificationID() {
		return reqNotificationID;
	}
	/**
	 * @param reqNotificationID the reqNotificationID to set
	 */
	public void setReqNotificationID(long reqNotificationID) {
		this.reqNotificationID = reqNotificationID;
	}
	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}
	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	/**
	 * @return the requestStatus
	 */
	public String getRequestStatus() {
		return requestStatus;
	}
	/**
	 * @param requestStatus the requestStatus to set
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	/**
	 * @return the notifyToID
	 */
	public long getNotifyToID() {
		return notifyToID;
	}
	/**
	 * @param notifyToID the notifyToID to set
	 */
	public void setNotifyToID(long notifyToID) {
		this.notifyToID = notifyToID;
	}
	/**
	 * @return the requestID
	 */
	public long getRequestID() {
		return requestID;
	}
	/**
	 * @param requestID the requestID to set
	 */
	public void setRequestID(long requestID) {
		this.requestID = requestID;
	}
	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	/**
	 * @return the utilUserDetails
	 */
	public UtilUserDetails getUtilUserDetails() {
		return utilUserDetails;
	}
	/**
	 * @param utilUserDetails the utilUserDetails to set
	 */
	public void setUtilUserDetails(UtilUserDetails utilUserDetails) {
		this.utilUserDetails = utilUserDetails;
	}
	
}
