package com.railway.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trains")
public class trains {
	@Id
	@Column(name="train_no")
	private int train_no;
	
	@Column(name="train_name")
	private String train_name;
	
	@Column(name="source")
	private String source;  
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="total_Seats_sleeper")
	private int total_Seats_sleeper;
	
	@Column(name="total_seats_Ac")
	private int total_seats_Ac; 
	
	@Column(name="distance")
	private int distance;
	
	
	 @OneToMany(mappedBy = "trains",cascade = CascadeType.ALL)
	 private List<train_info> train_info = new ArrayList<>();
		 
	
	
	public trains() {
		super();
		// TODO Auto-generated constructor stub
	}
	public trains(int train_no, String train_name, String source, String destination, int total_Seats_sleeper,
			int total_seats_Ac, int distance, List<com.railway.model.train_info> train_info) {
		super();
		this.train_no = train_no;
		this.train_name = train_name;
		this.source = source;
		this.destination = destination;
		this.total_Seats_sleeper = total_Seats_sleeper;
		this.total_seats_Ac = total_seats_Ac;
		this.distance = distance;
		this.train_info = train_info;
	}
	public List<train_info> getComments() {
		return train_info;
	}
	public void setComments(List<train_info> train_info) {
		this.train_info = train_info;
	}
	@Override
	public String toString() {
		return "Trains [train_no=" + train_no + ", train_name=" + train_name + ", source=" + source + ", destination="
				+ destination + ", total_Seats_sleeper=" + total_Seats_sleeper + ", total_seats_Ac=" + total_seats_Ac
				+ ", distance=" + distance + "]";
	}
	public int getTrain_no() {
		return train_no;
	}
	public void setTrain_no(int train_no) {
		this.train_no = train_no;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getTotal_Seats_sleeper() {
		return total_Seats_sleeper;
	}
	public void setTotal_Seats_sleeper(int total_Seats_sleeper) {
		this.total_Seats_sleeper = total_Seats_sleeper;
	}
	public int getTotal_seats_Ac() {
		return total_seats_Ac;
	}
	public void setTotal_seats_Ac(int total_seats_Ac) {
		this.total_seats_Ac = total_seats_Ac;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
