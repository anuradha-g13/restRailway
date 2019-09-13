package com.railway.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "train_info")
@Table(name = "train_info")
public class train_info {
	@Id
	@Column(name = "traininfonumber")
	private int traininfonumber;

	@ManyToOne
	@JoinColumn(name = "train_no")
	private trains trains;

	@OneToOne(mappedBy = "traininfonumber")
	private avaliable_seats avaliable_seats;

	@OneToMany(mappedBy = "train_info",  cascade = CascadeType.ALL)
	private List<tickets> tickets = new ArrayList<>();

	public train_info() {
		super();
		
	}

	@Column(name = "departure_date")
	private Date departure_date;

	@Column(name = "arrival_date")
	private Date arrival_date;

	public int getTraininfonumber() {
		return traininfonumber;
	}

	public void setTraininfonumber(int traininfonumber) {
		this.traininfonumber = traininfonumber;
	}

	public Date getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	public trains getTrains() {
		return trains;
	}

	public void setTrains(trains trains) {
		this.trains = trains;
	}

	public List<tickets> getTickets() {
		return tickets;
	}

	public void setTickets(List<tickets> tickets) {
		this.tickets = tickets;
	}

	

	public avaliable_seats getAvaliable_seats() {
		return avaliable_seats;
	}

	public void setAvaliable_seats(avaliable_seats avaliable_seats) {
		this.avaliable_seats = avaliable_seats;
	}

	

}
