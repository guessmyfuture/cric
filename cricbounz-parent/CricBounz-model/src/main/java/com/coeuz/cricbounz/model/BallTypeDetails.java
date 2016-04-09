package com.coeuz.cricbounz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "balltype")
@Component
public class BallTypeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ballId")
	private long ballId;
	
	private String ballType;
	public long getId() {
		return ballId;
	}
	public void setId(long id) {
		this.ballId = id;
	}
	public String getBallType() {
		return ballType;
	}
	public void setBallType(String ballType) {
		this.ballType = ballType;
	}
	

	

}
