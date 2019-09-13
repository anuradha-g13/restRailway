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

@Entity
@Table(name="passenger")
public class passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pnr_no")
	private int pnr_no;

	@ManyToOne
	@JoinColumn(name = "ticket_no")
	private tickets tickets;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;  
	
	@Column(name="travel_class")
	private String travel_class;
	
	@Column(name="age")
	private int age; 
	
	public passenger(int pnr_no, com.railway.model.tickets tickets, String name, String gender, String travel_class,
			int age, int seat_no, List<com.railway.model.train_info> train_info) {
		super();
		this.pnr_no = pnr_no;
		this.tickets = tickets;
		this.name = name;
		this.gender = gender;
		this.travel_class = travel_class;
		this.age = age;
		this.seat_no = seat_no;
		this.train_info = train_info;
	}



	@Override
	public String toString() {
		return "passenger [pnr_no=" + pnr_no + ", tickets=" + tickets + ", name=" + name + ", gender=" + gender
				+ ", travel_class=" + travel_class + ", age=" + age + ", seat_no=" + seat_no + ", train_info="
				+ train_info + "]";
	}



	@Column(name="seat_no")
	private int seat_no;
	
	
	 public int getPnr_no() {
		return pnr_no;
	}



	public void setPnr_no(int pnr_no) {
		this.pnr_no = pnr_no;
	}



	public tickets getTickets() {
		return tickets;
	}



	public void setTickets(tickets tickets) {
		this.tickets = tickets;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getTravel_class() {
		return travel_class;
	}



	public void setTravel_class(String travel_class) {
		this.travel_class = travel_class;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getSeat_no() {
		return seat_no;
	}



	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}



	public List<train_info> getTrain_info() {
		return train_info;
	}



	public void setTrain_info(List<train_info> train_info) {
		this.train_info = train_info;
	}



	@OneToMany(mappedBy = "trains",cascade = CascadeType.ALL)
	 private List<train_info> train_info = new ArrayList<>();
		 
	
	
	public passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
