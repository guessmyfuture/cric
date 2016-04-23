package com.coeuz.cricbounz.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tournament")
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	private String name;
	private Date registrationStartDate;
	private Date registrationEndDate;
	private Date tournamentStartDate;
	private Date tournamentEndDate;
	private String organizer;
	private String priceDetails;	
	private String winner;
	private String runner;
	private String manOfTheSeries;
	private String batsmanOfTheTournament;
	private String bowlerOfTheTournament;
	private String status;
	private String type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getPriceDetails() {
		return priceDetails;
	}
	public void setPriceDetails(String priceDetails) {
		this.priceDetails = priceDetails;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getRunner() {
		return runner;
	}
	public void setRunner(String runner) {
		this.runner = runner;
	}
	public String getManOfTheSeries() {
		return manOfTheSeries;
	}
	public void setManOfTheSeries(String manOfTheSeries) {
		this.manOfTheSeries = manOfTheSeries;
	}
	public String getBatsmanOfTheTournament() {
		return batsmanOfTheTournament;
	}
	public void setBatsmanOfTheTournament(String batsmanOfTheTournament) {
		this.batsmanOfTheTournament = batsmanOfTheTournament;
	}
	public String getBowlerOfTheTournament() {
		return bowlerOfTheTournament;
	}
	public void setBowlerOfTheTournament(String bowlerOfTheTournament) {
		this.bowlerOfTheTournament = bowlerOfTheTournament;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getRegistrationStartDate() {
		return registrationStartDate;
	}
	public void setRegistrationStartDate(Date registrationStartDate) {
		this.registrationStartDate = registrationStartDate;
	}
	public Date getRegistrationEndDate() {
		return registrationEndDate;
	}
	public void setRegistrationEndDate(Date registrationEndDate) {
		this.registrationEndDate = registrationEndDate;
	}
	public Date getTournamentStartDate() {
		return tournamentStartDate;
	}
	public void setTournamentStartDate(Date tournamentStartDate) {
		this.tournamentStartDate = tournamentStartDate;
	}
	public Date getTournamentEndDate() {
		return tournamentEndDate;
	}
	public void setTournamentEndDate(Date tournamentEndDate) {
		this.tournamentEndDate = tournamentEndDate;
	}
	
	
}


