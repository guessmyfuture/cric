package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "notificationdetails")
@Component
public class NotificationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	
	private long id;
	private long typeId;
	private String postedUser;
	private String notificationUser;
	private boolean accepeted;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getNotificationUser() {
		return notificationUser;
	}
	public void setNotificationUser(String notificationUser) {
		this.notificationUser = notificationUser;
	}
	public String getPostedUser() {
		return postedUser;
	}
	public void setPostedUser(String postedUser) {
		this.postedUser = postedUser;
	}	
	
	public boolean isAccepeted() {
		return accepeted;
	}
	public void setAccepeted(boolean accepeted) {
		this.accepeted = accepeted;
	}

}
