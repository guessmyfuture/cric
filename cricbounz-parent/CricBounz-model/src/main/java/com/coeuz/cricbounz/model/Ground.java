package com.coeuz.cricbounz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ground")
@Component
public class Ground {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "groundId")
	private long groundId;
	private String name;
	private String city;
	private String area;
	private String address;
	private String landmark;
	private String manager;
	private String contactno;
	private String balltype;
	private String pitchtype;
	private String activate;
	@Transient
	List<Slots> slotsList;

	/**
	 * @return the slotsList
	 */
	public List<Slots> getSlotsList() {
		return slotsList;
	}

	/**
	 * @param slotsList the slotsList to set
	 */
	public void setSlotsList(List<Slots> slotsList) {
		this.slotsList = slotsList;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getBalltype() {
		return balltype;
	}

	public void setBalltype(String balltype) {
		this.balltype = balltype;
	}

	public String getPitchtype() {
		return pitchtype;
	}

	public void setPitchtype(String pitchtype) {
		this.pitchtype = pitchtype;
	}

	public String getActivate() {
		return activate;
	}

	public void setActivate(String activate) {
		this.activate = activate;
	}
	
	  

}
