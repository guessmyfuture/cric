package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tournament")
@Component
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	private String name;
	@Transient
	private String registrationStartDate;
	@Transient
	private String registrationEndDate;
	@Transient
	private String tournamentStartDate;
	@Transient
	private String tournamentEndDate;
	
	private Date regStartDate;
	private Date regEndDate;
	private Date tourStartDate;
	private Date tourEndDate;
	private long organizer;
	private String priceDetails;	
	private long winner;
	private long runner;
	private long manOfTheSeries;
	private long batsmanOfTheTournament;
	private long bowlerOfTheTournament;
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
	public long getOrganizer() {
		return organizer;
	}
	public void setOrganizer(long organizer) {
		this.organizer = organizer;
	}
	public String getPriceDetails() {
		return priceDetails;
	}
	public void setPriceDetails(String priceDetails) {
		this.priceDetails = priceDetails;
	}
	public long getWinner() {
		return winner;
	}
	public void setWinner(long winner) {
		this.winner = winner;
	}
	public long getRunner() {
		return runner;
	}
	public void setRunner(long runner) {
		this.runner = runner;
	}
	public long getManOfTheSeries() {
		return manOfTheSeries;
	}
	public void setManOfTheSeries(long manOfTheSeries) {
		this.manOfTheSeries = manOfTheSeries;
	}
	public long getBatsmanOfTheTournament() {
		return batsmanOfTheTournament;
	}
	public void setBatsmanOfTheTournament(long batsmanOfTheTournament) {
		this.batsmanOfTheTournament = batsmanOfTheTournament;
	}
	public long getBowlerOfTheTournament() {
		return bowlerOfTheTournament;
	}
	public void setBowlerOfTheTournament(long bowlerOfTheTournament) {
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
	public String getRegistrationStartDate() {
		return registrationStartDate;
	}
	
	public String getRegistrationEndDate() {
		return registrationEndDate;
	}
	
	public String getTournamentStartDate() {
		return tournamentStartDate;
	}
	
	public String getTournamentEndDate() {
		return tournamentEndDate;
	}

	public Date getRegStartDate() {
		return regStartDate;
	}
	public void setRegStartDate(Date regStartDate) {
		this.regStartDate = regStartDate;
	}
	public Date getRegEndDate() {
		return regEndDate;
	}
	public void setRegEndDate(Date regEndDate) {
		this.regEndDate = regEndDate;
	}
	public Date getTourStartDate() {
		return tourStartDate;
	}
	public void setTourStartDate(Date tourStartDate) {
		this.tourStartDate = tourStartDate;
	}
	public Date getTourEndDate() {
		return tourEndDate;
	}
	public void setTourEndDate(Date tourEndDate) {
		this.tourEndDate = tourEndDate;
	}
	public void setRegistrationStartDate(String registrationStartDate) {
		this.registrationStartDate = registrationStartDate;
	}
	public void setRegistrationEndDate(String registrationEndDate) {
		this.registrationEndDate = registrationEndDate;
	}
	public void setTournamentStartDate(String tournamentStartDate) {
		this.tournamentStartDate = tournamentStartDate;
	}
	public void setTournamentEndDate(String tournamentEndDate) {
		this.tournamentEndDate = tournamentEndDate;
	}
}


