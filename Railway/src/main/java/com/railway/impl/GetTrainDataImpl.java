package com.railway.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.railway.Exception.TrainInfoNumberNotFound;
import com.railway.connections.Config;
import com.railway.connections.PersistenceManager;

import com.railway.helper.TrainsHelper;
import com.railway.model.train_info;
@Component
public class GetTrainDataImpl {

	EntityManager manager;
	private String getdailyTraindetail = "select TI from train_info TI where TI.traininfonumber=:trainInfoNumber";
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	ApplicationContext context;
	
	public TrainsHelper getTrainData(int trainInfoNumber) {

		TrainsHelper obj = context.getBean(TrainsHelper.class);
		manager = new PersistenceManager().getEntityManager();
		manager.getTransaction().begin();

		List<train_info> trainListdata = getTrain(trainInfoNumber);
		if (trainListdata.isEmpty()) {
			throw new TrainInfoNumberNotFound("no result fetched for " + trainInfoNumber);
		}
		obj = setTrainData(trainListdata);

		manager.getTransaction().commit();
		manager.close();

		return obj;
	}

	public List<train_info> getTrain(int trainInfoNumber) {

		Query query = manager.createQuery(getdailyTraindetail);
		query.setParameter("trainInfoNumber", trainInfoNumber);
		List<train_info> trainListdata = query.getResultList();

		return trainListdata;

	}

	public TrainsHelper setTrainData(List<train_info> trainListdata) {
		TrainsHelper obj =context.getBean(TrainsHelper.class);

		for (train_info train : trainListdata) {

			obj.setTrainInfoNumber(train.getTraininfonumber());
			obj.setTrainno(train.getTrains().getTrain_no());
			obj.setTrainname(train.getTrains().getTrain_name());
			obj.setSource(train.getTrains().getSource());
			obj.setDestination(train.getTrains().getDestination());
			obj.setDistance(train.getTrains().getDistance());
			obj.setDeparturedate(train.getDeparture_date());
			obj.setArrivaldate(train.getArrival_date());
		}

		return obj;

	}

}
