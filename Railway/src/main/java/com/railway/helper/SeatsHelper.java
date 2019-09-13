package com.railway.helper;

import java.sql.Date;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SeatsHelper implements AutoCloseable {
	int acSeats;
	int acFare;
	Date date;
	int traininfonumber;
	int trainNumber;
	int sleeperSeat;
	int sleeperFare;
	public int getSleeperFare() {
		return sleeperFare;
	}
	public void setSleeperFare(int sleeperFare) {
		this.sleeperFare = sleeperFare;
	}
	public int getAcFare() {
		return acFare;
	}
	public void setAcFare(int acFare) {
		this.acFare = acFare;
	}
	
	public int getTraininfonumber() {
		return traininfonumber;
	}
	public void setTraininfonumber(int traininfonumber) {
		this.traininfonumber = traininfonumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public int getSleeperSeat() {
		return sleeperSeat;
	}
	public void setSleeperSeat(int sleeperSeat) {
		this.sleeperSeat = sleeperSeat;
	}
	public int getAcSeats() {
		return acSeats;
	}
	public void setAcSeats(int acSeats) {
		this.acSeats = acSeats;
	}
	@Override
	public void close() throws Exception {

		
	}
	
	
	
}
