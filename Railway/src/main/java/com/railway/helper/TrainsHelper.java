package com.railway.helper;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class TrainsHelper {

	int trainInfoNumber;
	int trainno;
	int distance;
	String trainname;
	String source;
	String destination;
	Date departuredate;
	Date arrivaldate;
	public int getTrainInfoNumber() {
		return trainInfoNumber;
	}
	
	public void setTrainInfoNumber(int trainInfoNumber) {
		this.trainInfoNumber = trainInfoNumber;
	}
	public int getTrainno() {
		return trainno;
	}
	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
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


	public Date getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(Date departuredate) {
		this.departuredate = departuredate;
	}

	public Date getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(Date arrivaldate) {
		this.arrivaldate = arrivaldate;
	}
	
}
