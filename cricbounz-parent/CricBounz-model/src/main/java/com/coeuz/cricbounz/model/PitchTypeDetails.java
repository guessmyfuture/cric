package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pitchtype")
public class PitchTypeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pitchId")
	private long pitchId;
	private String pitchType;
	

	/**
	 * @return the id
	 */
	public long getId() {
		return pitchId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.pitchId = id;
	}

	/**
	 * @return the pitchType
	 */
	public String getPitchType() {
		return pitchType;
	}

	/**
	 * @param pitchType the pitchType to set
	 */
	public void setPitchType(String pitchType) {
		this.pitchType = pitchType;
	}

	

}
