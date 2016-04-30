package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matchscoredetails")
public class MatchScoreDetails {

	@Id
	@Column(name = "matchId")
	private long matchId;
	private String matchStatus;
	private String status;
	private String resultDescription;
	private String manOfTheMatch;
	private String innings;

	/**
	 * @return the innings
	 */
	public String getInnings() {
		return innings;
	}

	/**
	 * @param innings
	 *            the innings to set
	 */
	public void setInnings(String innings) {
		this.innings = innings;
	}

	/**
	 * @return the matchId
	 */
	public long getMatchId() {
		return matchId;
	}

	/**
	 * @param matchId
	 *            the matchId to set
	 */
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	/**
	 * @return the matchStatus
	 */
	public String getMatchStatus() {
		return matchStatus;
	}

	/**
	 * @param matchStatus
	 *            the matchStatus to set
	 */
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
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
	 * @return the resultDescription
	 */
	public String getResultDescription() {
		return resultDescription;
	}

	/**
	 * @param resultDescription
	 *            the resultDescription to set
	 */
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	/**
	 * @return the manOfTheMatch
	 */
	public String getManOfTheMatch() {
		return manOfTheMatch;
	}

	/**
	 * @param manOfTheMatch
	 *            the manOfTheMatch to set
	 */
	public void setManOfTheMatch(String manOfTheMatch) {
		this.manOfTheMatch = manOfTheMatch;
	}

}
