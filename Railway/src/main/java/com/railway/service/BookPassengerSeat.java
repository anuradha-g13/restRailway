package com.railway.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.railway.helper.PassengerHelper;
import com.railway.impl.BookTicketImpl;
import com.railway.impl.GetTicketImpl;
import com.railway.model.avaliable_seats;
@Component
public class BookPassengerSeat {
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	GetTicketImpl ticket;
	public int ticket(int infoNumber) {
		return ticket.getTicket(infoNumber);
	}

	public List<PassengerHelper>  bookTicketForPassenger(List<PassengerHelper> passengerList, int infoNumber,int ticketNo) {
		 List<Integer> pnr = new ArrayList<>();
		String result;
		ticketNo = ticket(infoNumber);
		if (ticketNo != 0) {
			BookTicketImpl book = new BookTicketImpl();
			passengerList = book.bookTickets(ticketNo, passengerList, infoNumber);

		} else {
			log.info("unable to create ticket");
		}
		return passengerList;
	}

}
