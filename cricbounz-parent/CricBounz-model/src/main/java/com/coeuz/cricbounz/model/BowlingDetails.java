package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bowlingDetails")
public class BowlingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bowlingDetailsId")
	private long bowlingDetailsId;
	private long bowlerId;
	private long runsConceded;
	private long dotBalls;
	private int noOfOvers;
	private int noOfWickets;
	private int wides;
	private int noBalls;
	private int maidenOvers;
	private long scoreDetailsId;

	/**
	 * @return the scoreDetailsId
	 */
	public long getScoreDetailsId() {
		return scoreDetailsId;
	}

	/**
	 * @param scoreDetailsId the scoreDetailsId to set
	 */
	public void setScoreDetailsId(long scoreDetailsId) {
		this.scoreDetailsId = scoreDetailsId;
	}

	/**
	 * @return the bowlingDetailsId
	 */
	public long getBowlingDetailsId() {
		return bowlingDetailsId;
	}

	/**
	 * @param bowlingDetailsId
	 *            the bowlingDetailsId to set
	 */
	public void setBowlingDetailsId(long bowlingDetailsId) {
		this.bowlingDetailsId = bowlingDetailsId;
	}

	/**
	 * @return the bowlerId
	 */
	public long getBowlerId() {
		return bowlerId;
	}

	/**
	 * @param bowlerId
	 *            the bowlerId to set
	 */
	public void setBowlerId(long bowlerId) {
		this.bowlerId = bowlerId;
	}

	/**
	 * @return the runsConceded
	 */
	public long getRunsConceded() {
		return runsConceded;
	}

	/**
	 * @param runsConceded
	 *            the runsConceded to set
	 */
	public void setRunsConceded(long runsConceded) {
		this.runsConceded = runsConceded;
	}

	/**
	 * @return the noOfOvers
	 */
	public int getNoOfOvers() {
		return noOfOvers;
	}

	/**
	 * @param noOfOvers
	 *            the noOfOvers to set
	 */
	public void setNoOfOvers(int noOfOvers) {
		this.noOfOvers = noOfOvers;
	}

	/**
	 * @return the noOfWickets
	 */
	public int getNoOfWickets() {
		return noOfWickets;
	}

	/**
	 * @param noOfWickets
	 *            the noOfWickets to set
	 */
	public void setNoOfWickets(int noOfWickets) {
		this.noOfWickets = noOfWickets;
	}

	/**
	 * @return the wides
	 */
	public int getWides() {
		return wides;
	}

	/**
	 * @param wides
	 *            the wides to set
	 */
	public void setWides(int wides) {
		this.wides = wides;
	}

	/**
	 * @return the noBalls
	 */
	public int getNoBalls() {
		return noBalls;
	}

	/**
	 * @param noBalls
	 *            the noBalls to set
	 */
	public void setNoBalls(int noBalls) {
		this.noBalls = noBalls;
	}

	/**
	 * @return the maidenOvers
	 */
	public int getMaidenOvers() {
		return maidenOvers;
	}

	/**
	 * @param maidenOvers
	 *            the maidenOvers to set
	 */
	public void setMaidenOvers(int maidenOvers) {
		this.maidenOvers = maidenOvers;
	}

	/**
	 * @return the dotBalls
	 */
	public long getDotBalls() {
		return dotBalls;
	}

	/**
	 * @param dotBalls
	 *            the dotBalls to set
	 */
	public void setDotBalls(long dotBalls) {
		this.dotBalls = dotBalls;
	}
}