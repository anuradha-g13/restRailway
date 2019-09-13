package com.railway.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.railway.Exception.InvalidInput;
import com.railway.Exception.TrainInfoNumberNotFound;
import com.railway.helper.TrainsHelper;
import com.railway.service.SearchTrain;

@RestController
@RequestMapping("/SearchTrains")
public class SearchTrains {
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	ApplicationContext context;

	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TrainsHelper>> searchTrains(@RequestParam String source,@RequestParam String destination, @RequestParam String date) {
		ResponseEntity<List<TrainsHelper>> response = new ResponseEntity<List<TrainsHelper>>(HttpStatus.BAD_REQUEST);
			try {

			log.info("source = " + source + ", destination = " + destination + "date =" + date);
			SearchTrain search = context.getBean(SearchTrain.class);
			List<TrainsHelper> list = search.searchTrainsBySrcDestinatioDate(source, destination, date);
			response=new ResponseEntity<List<TrainsHelper>>(list,HttpStatus.OK);
			
		} catch (TrainInfoNumberNotFound | InvalidInput | NullPointerException e) {
			

		}

		return response;

	}

}
