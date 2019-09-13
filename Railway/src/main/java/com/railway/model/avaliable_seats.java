package com.railway.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliable_seats")
public class avaliable_seats implements Serializable {

	@Id
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "traininfonumber")
	private train_info traininfonumber;

	@Column(name = "Avaliable_AC")
	private int Avaliable_AC;

	@Column(name = " Avaliable_sleeper")
	private int Avaliable_sleeper;

	public avaliable_seats() {
		super();

	}
	public train_info getTrain_info() {
		return traininfonumber;
	}

	public void setTrain_info(train_info train_info) {
		this.traininfonumber = train_info;
	}

	public int getAvaliable_AC() {
		return Avaliable_AC;
	}

	public void setAvaliable_AC(int avaliable_AC) {
		Avaliable_AC = avaliable_AC;
	}

	public int getAvaliable_sleeper() {
		return Avaliable_sleeper;
	}

	public void setAvaliable_sleeper(int avaliable_sleeper) {
		Avaliable_sleeper = avaliable_sleeper;
	}

}
