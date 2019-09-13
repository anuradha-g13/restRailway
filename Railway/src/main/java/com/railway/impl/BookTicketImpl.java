package com.railway.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.railway.connections.PersistenceManager;
import com.railway.helper.PassengerHelper;
import com.railway.model.passenger;
import com.railway.model.tickets;

@Component
public class BookTicketImpl {
	EntityManager manager;
	private final Logger log = Logger.getLogger(this.getClass());
	String insertsqlQuery = "insert into passenger(ticket_no,name,age,gender,travel_class) values(?,?,?,?,?)";
	String avaliableAcSeatsqlQuery = "select avaliable_ac from avaliable_seats where traininfonumber=(select traininfonumber from tickets where ticket_no=?)";
	String avaliableSleeperSeatsqlQuery = "select avaliable_sleeper from avaliable_seats where traininfonumber=(select traininfonumber from tickets where ticket_no=?)";
	
	@Autowired
	ApplicationContext context;

	public List<PassengerHelper> bookTickets(int ticketno, List<PassengerHelper> passengerList, int infoNumber) {

		manager = new PersistenceManager().getEntityManager();
		manager.getTransaction().begin();

		passengerList = addPassengers(ticketno, passengerList, infoNumber);
		manager.getTransaction().commit();
		manager.close();
		return passengerList;

	}

	public List<PassengerHelper> addPassengers(int ticketno, List<PassengerHelper> passengerList, int infoNumber) {
		int count = 0;
		int fare = 0;

		while (count < passengerList.size()) {

			PassengerHelper passengerHelper = passengerList.get(count);
			passenger obj = new passenger();
			tickets ticket = manager.find(tickets.class, ticketno);
			obj.setName(passengerHelper.getName());
			obj.setAge(passengerHelper.getAge());
			obj.setGender(passengerHelper.getGender());
			obj.setTravel_class(passengerHelper.getTravelclass());
			int passengerFare = getFare(passengerHelper.getTravelclass());
			fare = fare + passengerFare;
			ticket.setFare(fare);

			obj.setTickets(ticket);

			manager.persist(obj);
			blockSeat(obj, infoNumber);
			passengerHelper.setFare(passengerFare);
			passengerHelper.setPnrno(obj.getPnr_no());
			passengerHelper.setTicketno(ticketno);
			log.info("ticket created with pnrId = " + obj.getPnr_no());
			count++;
		}

		return passengerList;
	}

	public int blockSeat(passenger p, int infoNumber) {
		String block = "";
		if (p.getTravel_class().equals("A")) {
			block = "update avaliable_seats a set a.Avaliable_AC=a.Avaliable_AC-1  where a.traininfonumber.traininfonumber=:InfoNumber";
		} else {
			block = "UPDATE avaliable_seats a SET a.Avaliable_sleeper = a.Avaliable_sleeper-1 where a.traininfonumber.traininfonumber=:InfoNumber";

		}

		Query query = manager.createQuery(block);
		query.setParameter("InfoNumber", infoNumber);
		int update = query.executeUpdate();
		System.out.println(update);
		return update;
	}

	public int getFare(String type) {
		int fare = 0;
		if (type.equals("A")) {
			// fare=distance*AcRate;
			fare = 1600;
		} else if (type.equals("S")) {
			// fare=distance*AcRate;
			fare = 1000;
		}
		return fare;
	}

}
