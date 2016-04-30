package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ballDetails")
public class Balls {

	@Id
	@Column(name = "ballId")
	private long ballId;
	private String ballType;
	private String facedBy;
	private String RunType;
	private int runs;

	/**
	 * @return the ballId
	 */
	public long getBallId() {
		return ballId;
	}

	/**
	 * @param ballId
	 *            the ballId to set
	 */
	public void setBallId(long ballId) {
		this.ballId = ballId;
	}

	/**
	 * @return the ballType
	 */
	public String getBallType() {
		return ballType;
	}

	/**
	 * @param ballType
	 *            the ballType to set
	 */
	public void setBallType(String ballType) {
		this.ballType = ballType;
	}

	/**
	 * @return the facedBy
	 */
	public String getFacedBy() {
		return facedBy;
	}

	/**
	 * @param facedBy
	 *            the facedBy to set
	 */
	public void setFacedBy(String facedBy) {
		this.facedBy = facedBy;
	}

	/**
	 * @return the runType
	 */
	public String getRunType() {
		return RunType;
	}

	/**
	 * @param runType
	 *            the runType to set
	 */
	public void setRunType(String runType) {
		RunType = runType;
	}

	/**
	 * @return the runs
	 */
	public int getRuns() {
		return runs;
	}

	/**
	 * @param runs
	 *            the runs to set
	 */
	public void setRuns(int runs) {
		this.runs = runs;
	}

}