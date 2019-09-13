
package com.railway.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.railway.Exception.TrainInfoNumberNotFound;
import com.railway.connections.PersistenceManager;
import com.railway.helper.TrainsHelper;
import com.railway.model.train_info;
import com.railway.model.trains;
@Component
public class GetAvaliableTrainsImpl {
	
	
	EntityManager manager;
	private final Logger log = Logger.getLogger(this.getClass());
	String getTrainsList = "select t from trains t where t.source like :source and t.destination like :destination";
	String getTrainsListByDate = "select ti from train_info ti where ti.trains= :train_no and ti.departure_date = :date";

	public List<TrainsHelper> getTrainsList(String source, String destination, Date date1) {

		manager = new PersistenceManager().getEntityManager();
		List<TrainsHelper> trainList;
		manager.getTransaction().begin();

		List<trains> trainListdata = getTrains(source, destination);
		trainList = setTrains(trainListdata, date1);

		manager.getTransaction().commit();
		manager.close();
		return trainList;

	}

	public List<trains> getTrains(String source, String destination) {

		Query query = manager.createQuery(getTrainsList);
		query.setParameter("source", "%" + source + "%");
		query.setParameter("destination", "%" + destination + "%");
		List<trains> trainListdata = query.getResultList();

		if (trainListdata.isEmpty()) {
			throw new TrainInfoNumberNotFound("no result fetched for " + source + " , " + destination);
		}
		return trainListdata;
	}

	public List<TrainsHelper> setTrains(List<trains> trainListdata, Date date1) {
		ArrayList<TrainsHelper> trainList = new ArrayList<>();

		for (trains train : trainListdata) {

			Query query = manager.createQuery(getTrainsListByDate);
			query.setParameter("train_no", train);
			query.setParameter("date", date1);
			List<train_info> trainInfo = query.getResultList();

			for (train_info detail : trainInfo) {
				TrainsHelper obj = new TrainsHelper();
				obj.setTrainInfoNumber(detail.getTraininfonumber());
				obj.setSource(train.getSource());
				obj.setDestination(train.getDestination());
				obj.setArrivaldate(detail.getArrival_date());
				obj.setDeparturedate(detail.getDeparture_date());
				obj.setDistance(train.getDistance());
				trainList.add(obj);

			}

		}
		return trainList;
	}

}
