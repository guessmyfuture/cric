package com.coeuz.cricbounz.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "scoreDetails")
public class ScoreUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scoreDetailsId")
	private long scoreDetailsId;
	private int totalScore;
	private int noBalls;
	private int wides;
	private int byes;
	private int legByes;
	private int wickets;
	private int overs;
	@OneToMany
	@JoinColumn(name = "scoreDetailsId")
	private Set<BattingDetails> battingDetails;

	@OneToMany
	@JoinColumn(name = "scoreDetailsId")
	private Set<BowlingDetails> bowlingDetails;
	private long inningsId;

	/**
	 * @return the inningsId
	 */
	public long getInningsId() {
		return inningsId;
	}

	/**
	 * @param inningsId
	 *            the inningsId to set
	 */
	public void setInningsId(long inningsId) {
		this.inningsId = inningsId;
	}

	/**
	 * @return the scoreDetailsId
	 */
	public long getScoreDetailsId() {
		return scoreDetailsId;
	}

	/**
	 * @param scoreDetailsId
	 *            the scoreDetailsId to set
	 */
	public void setScoreDetailsId(long scoreDetailsId) {
		this.scoreDetailsId = scoreDetailsId;
	}

	/**
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore
	 *            the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
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
	 * @return the byes
	 */
	public int getByes() {
		return byes;
	}

	/**
	 * @param byes
	 *            the byes to set
	 */
	public void setByes(int byes) {
		this.byes = byes;
	}

	/**
	 * @return the legByes
	 */
	public int getLegByes() {
		return legByes;
	}

	/**
	 * @param legByes
	 *            the legByes to set
	 */
	public void setLegByes(int legByes) {
		this.legByes = legByes;
	}

	/**
	 * @return the battingDetails
	 */
	public Set<BattingDetails> getBattingDetails() {
		return battingDetails;
	}

	/**
	 * @param battingDetails
	 *            the battingDetails to set
	 */
	@SuppressWarnings("unchecked")
	public void setBattingDetails(List<BattingDetails> battingDetails) {
		this.battingDetails = (Set<BattingDetails>) battingDetails;
	}

	/**
	 * @return the bowlingDetails
	 */
	public Set<BowlingDetails> getBowlingDetails() {
		return bowlingDetails;
	}

	/**
	 * @param bowlingDetails
	 *            the bowlingDetails to set
	 */
	public void setBowlingDetails(Set<BowlingDetails> bowlingDetails) {
		this.bowlingDetails = bowlingDetails;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getOvers() {
		return overs;
	}

	public void setOvers(int overs) {
		this.overs = overs;
	}

	public void setBattingDetails(Set<BattingDetails> battingDetails) {
		this.battingDetails = battingDetails;
	}

}