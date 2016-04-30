package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "battingDetails")
public class BattingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "battingDetailsId")
	private long battingDetailsId;
	private long scoreDetailsId;
	private long batsmanId;
	private long score;
	private long ballsFaced;
	private long dotBalls;
	private long OtherPlayerInvolved;
	private long wicketTakenBy;
	private long wicketType;
	private String status;
	private int sixes;
	private int fours;
	private int ones;
	private int twos;
	private int threes;

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
	 * @return the battingDetailsId
	 */
	public long getBattingDetailsId() {
		return battingDetailsId;
	}

	/**
	 * @param battingDetailsId
	 *            the battingDetailsId to set
	 */
	public void setBattingDetailsId(long battingDetailsId) {
		this.battingDetailsId = battingDetailsId;
	}

	/**
	 * @return the batsmanId
	 */
	public long getBatsmanId() {
		return batsmanId;
	}

	/**
	 * @param batsmanId
	 *            the batsmanId to set
	 */
	public void setBatsmanId(long batsmanId) {
		this.batsmanId = batsmanId;
	}

	/**
	 * @return the score
	 */
	public long getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/**
	 * @return the ballsFaced
	 */
	public long getBallsFaced() {
		return ballsFaced;
	}

	/**
	 * @param ballsFaced
	 *            the ballsFaced to set
	 */
	public void setBallsFaced(long ballsFaced) {
		this.ballsFaced = ballsFaced;
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

	/**
	 * @return the otherPlayerInvolved
	 */
	public long getOtherPlayerInvolved() {
		return OtherPlayerInvolved;
	}

	/**
	 * @param otherPlayerInvolved
	 *            the otherPlayerInvolved to set
	 */
	public void setOtherPlayerInvolved(long otherPlayerInvolved) {
		OtherPlayerInvolved = otherPlayerInvolved;
	}

	/**
	 * @return the wicketTakenBy
	 */
	public long getWicketTakenBy() {
		return wicketTakenBy;
	}

	/**
	 * @param wicketTakenBy
	 *            the wicketTakenBy to set
	 */
	public void setWicketTakenBy(long wicketTakenBy) {
		this.wicketTakenBy = wicketTakenBy;
	}

	/**
	 * @return the wicketType
	 */
	public long getWicketType() {
		return wicketType;
	}

	/**
	 * @param wicketType
	 *            the wicketType to set
	 */
	public void setWicketType(long wicketType) {
		this.wicketType = wicketType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the sixes
	 */
	public int getSixes() {
		return sixes;
	}

	/**
	 * @param sixes
	 *            the sixes to set
	 */
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	/**
	 * @return the fours
	 */
	public int getFours() {
		return fours;
	}

	/**
	 * @param fours
	 *            the fours to set
	 */
	public void setFours(int fours) {
		this.fours = fours;
	}

	/**
	 * @return the ones
	 */
	public int getOnes() {
		return ones;
	}

	/**
	 * @param ones
	 *            the ones to set
	 */
	public void setOnes(int ones) {
		this.ones = ones;
	}

	/**
	 * @return the twos
	 */
	public int getTwos() {
		return twos;
	}

	/**
	 * @param twos
	 *            the twos to set
	 */
	public void setTwos(int twos) {
		this.twos = twos;
	}

	/**
	 * @return the threes
	 */
	public int getThrees() {
		return threes;
	}

	/**
	 * @param threes
	 *            the threes to set
	 */
	public void setThrees(int threes) {
		this.threes = threes;
	}
}