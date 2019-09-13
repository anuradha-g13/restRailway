package com.railway.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "tickets")
@Table(name = "tickets")
public class tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_no")
	private int ticket_no;

	@Column(name = "user_id")
	private String user_id;

	@ManyToOne
	@JoinColumn(name = "traininfonumber")
	private train_info train_info;

	public List<passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<passenger> passenger) {
		this.passenger = passenger;
	}

	@Column(name = "cancle_id",nullable = true)
	private int cancle_id;

	@Column(name = "fare")
	private int fare;

	@OneToMany(mappedBy = "tickets",cascade = CascadeType.ALL)
	 private List<passenger> passenger = new ArrayList<>();
		 
	
	public tickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTicket_no() {
		return ticket_no;
	}

	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public train_info getTrain_info() {
		return train_info;
	}

	public void setTrain_info(train_info train_info) {
		this.train_info = train_info;
	}

	public int getCancle_id() {
		return cancle_id;
	}

	public void setCancle_id(int cancle_id) {
		this.cancle_id = cancle_id;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	
	@Override
	public String toString() {
		return "tickets [ticket_no=" + ticket_no + ", user_id=" + user_id + ", train_info=" + train_info
				+ ", cancle_id=" + cancle_id + ", fare=" + fare + ", passenger=" + passenger + "]";
	}

	public tickets(int ticket_no, String user_id, com.railway.model.train_info train_info, int cancle_id, int fare) {
		super();
		this.ticket_no = ticket_no;
		this.user_id = user_id;
		this.train_info = train_info;
		this.cancle_id = cancle_id;
		this.fare = fare;
	}

}
