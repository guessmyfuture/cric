package com.coeuz.cricbounz.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "matchdetails")
@Component
public class MatchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "matchID")
	private long matchID;
	private long teamAId;
	private long teamBId;
	private String venue;
	private String status;
	private Date playingDate;
	@Transient
	private String matchDate;
	private int overs;
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	private long wonBy;
	private long umpire1;
	private long umpire2;
	private String ballType;
	private long scorer;
	private long pitchType;
	private String resultDescription;
	private long manOfTheMatch;
	private long tournamentId;
	private String matchType;
	private int group;
	private long createdBy;
	private int slot;
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public long getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the manOfTheMatch
	 */
	public long getManOfTheMatch() {
		return manOfTheMatch;
	}
	/**
	 * @param manOfTheMatch the manOfTheMatch to set
	 */
	public void setManOfTheMatch(long manOfTheMatch) {
		this.manOfTheMatch = manOfTheMatch;
	}
	@OneToMany
    @JoinColumn(name="matchId")
	private List<Innings> innings;
	/**
	 * @return the matchID
	 */
	public long getMatchID() {
		return matchID;
	}
	/**
	 * @param matchID the matchID to set
	 */
	public void setMatchID(long matchID) {
		this.matchID = matchID;
	}
	/**
	 * @return the teamAId
	 */
	public long getTeamAId() {
		return teamAId;
	}
	/**
	 * @param teamAId the teamAId to set
	 */
	public void setTeamAId(long teamAId) {
		this.teamAId = teamAId;
	}
	/**
	 * @return the teamBId
	 */
	public long getTeamBId() {
		return teamBId;
	}
	/**
	 * @param teamBId the teamBId to set
	 */
	public void setTeamBId(long teamBId) {
		this.teamBId = teamBId;
	}
	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getPlayingDate() {
		return playingDate;
	}
	public void setPlayingDate(Date playingDate) {
		this.playingDate = playingDate;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	/**
	 * @return the wonBy
	 */
	public long getWonBy() {
		return wonBy;
	}
	/**
	 * @param wonBy the wonBy to set
	 */
	public void setWonBy(long wonBy) {
		this.wonBy = wonBy;
	}
	/**
	 * @return the umpire1
	 */
	public long getUmpire1() {
		return umpire1;
	}
	/**
	 * @param umpire1 the umpire1 to set
	 */
	public void setUmpire1(long umpire1) {
		this.umpire1 = umpire1;
	}
	/**
	 * @return the umpire2
	 */
	public long getUmpire2() {
		return umpire2;
	}
	/**
	 * @param umpire2 the umpire2 to set
	 */
	public void setUmpire2(long umpire2) {
		this.umpire2 = umpire2;
	}
	/**
	 * @return the ballType
	 */
	public String getBallType() {
		return ballType;
	}
	/**
	 * @param ballType the ballType to set
	 */
	public void setBallType(String ballType) {
		this.ballType = ballType;
	}
	/**
	 * @return the scorer
	 */
	public long getScorer() {
		return scorer;
	}
	/**
	 * @param scorer the scorer to set
	 */
	public void setScorer(long scorer) {
		this.scorer = scorer;
	}
	/**
	 * @return the pitchType
	 */
	public long getPitchType() {
		return pitchType;
	}
	/**
	 * @param pitchType the pitchType to set
	 */
	public void setPitchType(long pitchType) {
		this.pitchType = pitchType;
	}
	/**
	 * @return the resultDescription
	 */
	public String getResultDescription() {
		return resultDescription;
	}
	/**
	 * @param resultDescription the resultDescription to set
	 */
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	
	/**
	 * @return the innings
	 */
	public List<Innings> getInnings() {
		return innings;
	}
	/**
	 * @param innings the innings to set
	 */
	public void setInnings(List<Innings> innings) {
		this.innings = innings;
	}
	
	
	
}
