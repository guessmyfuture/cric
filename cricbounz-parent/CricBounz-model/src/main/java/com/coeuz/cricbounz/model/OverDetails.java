package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "overDetails")
public class OverDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "overDetailsId")
	private long overDetailsId;
	private String bowler;
	private String overId;
	private String ballDetails;
	private long inningsId;

	/**
	 * @return the inningsId
	 */
	public long getInningsId() {
		return inningsId;
	}

	/**
	 * @param inningsId the inningsId to set
	 */
	public void setInningsId(long inningsId) {
		this.inningsId = inningsId;
	}

	/**
	 * @return the overDetailsId
	 */
	public long getOverDetailsId() {
		return overDetailsId;
	}

	/**
	 * @param overDetailsId
	 *            the overDetailsId to set
	 */
	public void setOverDetailsId(long overDetailsId) {
		this.overDetailsId = overDetailsId;
	}

	/**
	 * @return the bowler
	 */
	public String getBowler() {
		return bowler;
	}

	/**
	 * @param bowler
	 *            the bowler to set
	 */
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}

	/**
	 * @return the overId
	 */
	public String getOverId() {
		return overId;
	}

	/**
	 * @param overId
	 *            the overId to set
	 */
	public void setOverId(String overId) {
		this.overId = overId;
	}

	/**
	 * @return the ballDetails
	 */
	public String getBallDetails() {
		return ballDetails;
	}

	/**
	 * @param ballDetails
	 *            the ballDetails to set
	 */
	public void setBallDetails(String ballDetails) {
		this.ballDetails = ballDetails;
	}
}