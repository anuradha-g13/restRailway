package com.railway.helper;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PassengerHelper {

	int pnrno;
	int ticketno;
	int age;
	int fare;
	String name, gender, travelclass;

	public int getPnrno() {
		return pnrno;
	}

	public void setPnrno(int pnrno) {
		this.pnrno = pnrno;
	}

	public int getTicketno() {
		return ticketno;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public void setTicketno(int ticketno) {
		this.ticketno = ticketno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTravelclass() {
		return travelclass;
	}

	public void setTravelclass(String travelclass) {
		this.travelclass = travelclass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
