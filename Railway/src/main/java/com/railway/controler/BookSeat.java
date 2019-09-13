package com.railway.controler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.railway.Exception.InvalidInput;
import com.railway.helper.PassengerHelper;
import com.railway.service.BookPassengerSeat;
import com.railway.service.SetPassengers;

@RestController
@RequestMapping("/BookSeat")
public class BookSeat {
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	ApplicationContext context;

	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	protected ModelAndView Book(@RequestBody Map<String,Object> passengers) {

		String action = (String) passengers.get("action");
		int infoNumber = (int) passengers.get("InfoNumber");
		List<PassengerHelper> o=(List<PassengerHelper>) passengers.get("passengerDetail");
		System.out.println(o);
		ModelAndView mv = new ModelAndView();
		System.out.println("data" + passengers);
		log.info("request got for booking " + action + " ticket for train info number" + infoNumber);
		
		try {
			SetPassengers passenger = context.getBean(SetPassengers.class);
//			List<PassengerHelper> passengerList = passenger.addPassengers(name, age, gender, action);
			
			BookPassengerSeat obj = context.getBean(BookPassengerSeat.class);
			int ticketNo = obj.ticket(infoNumber);
			
//			passengerList = obj.bookTicketForPassenger(passengerList, infoNumber, ticketNo);
			
			mv.setViewName("PnrStatus");
			if (ticketNo == 0) {
				mv.addObject("errorMsg", "unable to book the ticket at this moment for this train");
			} else {

//				mv.addObject("pnr", passengerList);

			}
		} catch (InvalidInput e) {
			mv.addObject("errormsg", e.getMessage());

		}
		return mv;
	}

}
