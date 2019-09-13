package com.railway.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.railway.helper.SeatsHelper;
import com.railway.helper.TrainsHelper;
import com.railway.service.GetSeats;
import com.railway.service.GetTrainDetails;

@RestController
@RequestMapping("/SearchSeats/{trainInfoNumber}")
public class SearchSeats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	ApplicationContext context;
	@Autowired
	GetSeats seat;
	@Autowired
	GetTrainDetails trainData;
	@RequestMapping(method = RequestMethod.GET)
	protected Map Get(@PathVariable int trainInfoNumber) {

		TrainsHelper train = trainData.getTrainData(trainInfoNumber);
		List<SeatsHelper> avaliableSeats = seat.getSeatsOf6Days(trainInfoNumber);
		Map<String, Object> trainSeats = new HashMap<String, Object>();
		trainSeats.put("train", train);
		trainSeats.put("avaliableSeats", avaliableSeats);

		return trainSeats;
	}

}
