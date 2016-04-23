package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "slots")
@Component
public class Slots {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "slotId")
	private long slotId;
	private String slotStartTime;
	private String slotEndTime;
	private long groundId;
	
	@Transient
	private String available;
		
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
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
	
	/**
	 * @return the slotStartTime
	 */
	public String getSlotStartTime() {
		return slotStartTime;
	}
	
	/**
	 * @param slotStartTime the slotStartTime to set
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
	 * @param slotEndTime the slotEndTime to set
	 */
	public void setSlotEndTime(String slotEndTime) {
		this.slotEndTime = slotEndTime;
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
}
