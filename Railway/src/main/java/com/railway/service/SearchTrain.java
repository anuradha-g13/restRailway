package com.railway.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.railway.Exception.DBNotConnected;
import com.railway.Exception.InvalidInput;
import com.railway.Exception.TrainInfoNumberNotFound;
import com.railway.helper.TrainsHelper;
import com.railway.impl.GetAvaliableTrainsImpl;
import com.railway.validate.ValidateForTrainSearch;
@Component
public class SearchTrain {
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	GetAvaliableTrainsImpl getTrains;
	@Autowired
	ValidateForTrainSearch check;

	public List<TrainsHelper> searchTrainsBySrcDestinatioDate(String source, String destination, String date)
			throws TrainInfoNumberNotFound, InvalidInput {

		check(source, destination, date);
		List<TrainsHelper> trainList = new ArrayList<>();
		try {
			trainList = getTrains.getTrainsList(source, destination, Date.valueOf(date));
			log.info("trains list fetched " + trainList);
		} catch (DBNotConnected e) {

			log.info(e.getMessage());

		}
		return trainList;

	}

	public void check(String source, String destination, String date) throws TrainInfoNumberNotFound, InvalidInput {
		
	
			check.checkSourceDestination(source);
			check.checkSourceDestination(destination);
			check.checkDate(date);
		
	}

}
