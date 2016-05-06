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
@Table(name = "matches")
@Component
public class Matches {

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
	
	private long owner;

	private long wonBy;
	private long umpire1;
	private long umpire2;
	private String ballType;
	private long scorer;
	private long pitchType;
	private String resultDescription;
	private long manOfTheMatch;
	private long tournamentId;
	private String areaName;
	private String cityName;
	private int slotNumber;
	private int groupNumber;
	private String matchInfo;
	
	
	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@OneToMany
	@JoinColumn(name="matchID")
	private List <Innings> inningsDetails;

	/**
	 * @return the inningsDetails
	 */
	public List<Innings> getInningsDetails() {
		return inningsDetails;
	}

	/**
	 * @param inningsDetails the inningsDetails to set
	 */
	public void setInningsDetails(List<Innings> inningsDetails) {
		this.inningsDetails = inningsDetails;
	}

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
	 * @return the teamAId
	 */
	public long getTeamAId() {
		return teamAId;
	}

	/**
	 * @param teamAId
	 *            the teamAId to set
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
	 * @param teamBId
	 *            the teamBId to set
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
	 * @param venue
	 *            the venue to set
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
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the playingDate
	 */
	public Date getPlayingDate() {
		return playingDate;
	}

	/**
	 * @param playingDate
	 *            the playingDate to set
	 */
	public void setPlayingDate(Date playingDate) {
		this.playingDate = playingDate;
	}

	/**
	 * @return the matchDate
	 */
	public String getMatchDate() {
		return matchDate;
	}

	/**
	 * @param matchDate
	 *            the matchDate to set
	 */
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	/**
	 * @return the overs
	 */
	public int getOvers() {
		return overs;
	}

	/**
	 * @param overs
	 *            the overs to set
	 */
	public void setOvers(int overs) {
		this.overs = overs;
	}

	/**
	 * @return the wonBy
	 */
	public long getWonBy() {
		return wonBy;
	}

	/**
	 * @param wonBy
	 *            the wonBy to set
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
	 * @param umpire1
	 *            the umpire1 to set
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
	 * @param umpire2
	 *            the umpire2 to set
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
	 * @param ballType
	 *            the ballType to set
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
	 * @param scorer
	 *            the scorer to set
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
	 * @param pitchType
	 *            the pitchType to set
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
	 * @param resultDescription
	 *            the resultDescription to set
	 */
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	/**
	 * @return the manOfTheMatch
	 */
	public long getManOfTheMatch() {
		return manOfTheMatch;
	}

	/**
	 * @param manOfTheMatch
	 *            the manOfTheMatch to set
	 */
	public void setManOfTheMatch(long manOfTheMatch) {
		this.manOfTheMatch = manOfTheMatch;
	}

	/**
	 * @return the tournamentId
	 */
	public long getTournamentId() {
		return tournamentId;
	}

	/**
	 * @param tournamentId
	 *            the tournamentId to set
	 */
	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}

	/**
	 * @return the owner
	 */
	public long getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(long owner) {
		this.owner = owner;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the slotNumber
	 */
	public int getSlotNumber() {
		return slotNumber;
	}

	/**
	 * @param slotNumber the slotNumber to set
	 */
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	/**
	 * @return the groupNumber
	 */
	public int getGroupNumber() {
		return groupNumber;
	}

	/**
	 * @param groupNumber the groupNumber to set
	 */
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	/**
	 * @return the matchInfo
	 */
	public String getMatchInfo() {
		return matchInfo;
	}

	/**
	 * @param matchInfo the matchInfo to set
	 */
	public void setMatchInfo(String matchInfo) {
		this.matchInfo = matchInfo;
	}

}
