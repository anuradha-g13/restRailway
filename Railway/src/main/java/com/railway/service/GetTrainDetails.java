package com.railway.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.railway.Exception.TrainInfoNumberNotFound;
import com.railway.helper.TrainsHelper;
import com.railway.impl.GetTrainDataImpl;

@Component
public class GetTrainDetails {
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	GetTrainDataImpl trainDetail;
	@Autowired
	TrainsHelper obj;

	public TrainsHelper getTrainData(int trainInfoNumber) {

		try {

			obj = trainDetail.getTrainData(trainInfoNumber);
		} catch (TrainInfoNumberNotFound e) {
			log.info("result not found for " + trainInfoNumber);
			throw new TrainInfoNumberNotFound("no result fetched for " + trainInfoNumber);
		}

		return obj;
	}

}
