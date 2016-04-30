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
@Table(name = "inningsdetails")
public class Innings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inningsId")
	private long inningsId;
	private long matchID;
	private String inningsType;
	private String battingTeam;
	private String bowlingTeam;
	@OneToMany
	@JoinColumn(name = "inningsId")
	private Set<ScoreUpdate> scoreUpdate;
	@OneToMany
	@JoinColumn(name = "inningsId")
	private List<OverDetails> overDetails;

	/**
	 * @return the matchID
	 */
	public long getMatchID() {
		return matchID;
	}

	/**
	 * @param matchID
	 *            the matchID to set
	 */
	public void setMatchID(long matchID) {
		this.matchID = matchID;
	}

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
	 * @return the inningsType
	 */
	public String getInningsType() {
		return inningsType;
	}

	/**
	 * @param inningsType
	 *            the inningsType to set
	 */
	public void setInningsType(String inningsType) {
		this.inningsType = inningsType;
	}

	/**
	 * @return the battingTeam
	 */
	public String getBattingTeam() {
		return battingTeam;
	}

	/**
	 * @param battingTeam
	 *            the battingTeam to set
	 */
	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	/**
	 * @return the bowlingTeam
	 */
	public String getBowlingTeam() {
		return bowlingTeam;
	}

	/**
	 * @param bowlingTeam
	 *            the bowlingTeam to set
	 */
	public void setBowlingTeam(String bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}

	/**
	 * @return the scoreUpdate
	 */
	public Set<ScoreUpdate> getScoreUpdate() {
		return scoreUpdate;
	}

	/**
	 * @param scoreUpdate
	 *            the scoreUpdate to set
	 */
	public void setScoreUpdate(Set<ScoreUpdate> scoreUpdate) {
		this.scoreUpdate = scoreUpdate;
	}

	/**
	 * @return the overDetails
	 */
	public List<OverDetails> getOverDetails() {
		return overDetails;
	}

	/**
	 * @param overDetails
	 *            the overDetails to set
	 */
	public void setOverDetails(List<OverDetails> overDetails) {
		this.overDetails = overDetails;
	}
}