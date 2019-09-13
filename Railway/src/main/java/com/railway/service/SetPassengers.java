package com.railway.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.railway.Exception.InvalidInput;
import com.railway.connections.Config;

import com.railway.helper.PassengerHelper;
import com.railway.validate.ValidatePassengerForBookSeat;

@Component
public class SetPassengers {
	@Autowired
	ValidatePassengerForBookSeat check;
	@Autowired
	ApplicationContext context;
	public ArrayList<PassengerHelper> addPassengers(String[] name,String[] age,String[] gender,String action)  throws InvalidInput{
		ArrayList<PassengerHelper> passengerList = new ArrayList<>();
		

		check.checkName(name);
		check.checkAge(age);
		check.checkGender(gender);
		check.checkAction(action);
		int noOfPassenger = name.length;
		
		
		while (noOfPassenger != 0) {
			PassengerHelper passenger =context.getBean(PassengerHelper.class);
			passenger.setAge(Integer.parseInt(age[noOfPassenger - 1]));
			passenger.setGender(gender[noOfPassenger - 1]);
			passenger.setName(name[noOfPassenger - 1]);
			if (action.equals("BookAC"))
				passenger.setTravelclass("A");
			if (action.equals("BookSleeper"))
				passenger.setTravelclass("S");

			passengerList.add(passenger);

			noOfPassenger--;
			
		}
		
		return passengerList;
	}
}
