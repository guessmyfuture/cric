package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private long requestedBy;
	private long requestedTo;
	private Date requestedDate;
	private  String status;
		
	public long getFiendReqId() {
		return fiendReqId;
	}
	public void setFiendReqId(long fiendReqId) {
		this.fiendReqId = fiendReqId;
	}
		
	public long getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(long requestedBy) {
		this.requestedBy = requestedBy;
	}
	public long getRequestedTo() {
		return requestedTo;
	}
	public void setRequestedTo(long requestedTo) {
		this.requestedTo = requestedTo;
	}
	public Date getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
