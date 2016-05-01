package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "liveaction")
@Component
public class LiveAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="liveID")
	private long liveID;
	@Column(unique=true)
	private long playerId;
	public long getLiveID() {
		return liveID;
	}
	public void setLiveID(long liveID) {
		this.liveID = liveID;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
}
