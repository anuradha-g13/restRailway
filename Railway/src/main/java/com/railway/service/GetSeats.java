package com.railway.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.railway.Exception.TrainInfoNumberNotFound;
import com.railway.connections.PersistenceManager;

import com.railway.helper.SeatsHelper;
import com.railway.impl.CalculateFare;
import com.railway.model.train_info;
@Component
public class GetSeats {
	EntityManager manager;
	private final Logger log = Logger.getLogger(this.getClass());
	static Scanner sc = new Scanner(System.in);
	@Autowired
	ApplicationContext context;
	String GETTRAINDETAILS = "select a from train_info a where a.traininfonumber=:trainInfoNumber";
	String GETTRAINNUMBERS = "select t from train_info t where t.traininfonumber=:trainInfoNumber";
	String GETTRAININFO = "select t from train_info t where t.trains.train_no=:trainno and t.departure_date=:departureDate";

	public SeatsHelper seats(int trainInfoNumber) {

		SeatsHelper seat = null;
		manager = new PersistenceManager().getEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery(GETTRAINDETAILS);
		query.setParameter("trainInfoNumber", trainInfoNumber);
		List<train_info> information = query.getResultList();
		if (information.isEmpty()) {
			log.info("no seats found with given date");
		}
		for (train_info s : information) {

			seat = setSeatData(s);
		}
		manager.getTransaction().commit();
		manager.close();

		return seat;

	}

	public SeatsHelper setSeatData(train_info t) {
		SeatsHelper seat = context.getBean(SeatsHelper.class);
		CalculateFare fare = context.getBean(CalculateFare.class);

		seat.setTraininfonumber(t.getTraininfonumber());
		seat.setDate(t.getDeparture_date());
		seat.setAcSeats(t.getAvaliable_seats().getAvaliable_AC());
		seat.setSleeperSeat(t.getAvaliable_seats().getAvaliable_sleeper());
		seat = fare.getFare(t.getTrains().getDistance(), seat);

		return seat;
	}

	public List<SeatsHelper> getSeatsOf6Days(int trainInfoNumber) {
		ArrayList<Integer> trainInfoNumberList = (ArrayList<Integer>) getTrainInfoNumberOf6DayList(trainInfoNumber);
		ArrayList<SeatsHelper> seatsList = new ArrayList<>();

		for (int number : trainInfoNumberList) {
			seatsList.add(seats(number));

		}

		return seatsList;
	}

	public List<Integer> getTrainInfoNumberOf6DayList(int trainInfoNumber) {

		ArrayList<Integer> trainInfoNumberList = new ArrayList<>();
		manager = new PersistenceManager().getEntityManager();
		manager.getTransaction().begin();
		try {

			Query query = manager.createQuery(GETTRAINNUMBERS);
			query.setParameter("trainInfoNumber", trainInfoNumber);
			List<train_info> information = query.getResultList();

			if (information.isEmpty()) {
				throw new TrainInfoNumberNotFound("no result fetched for this train");
			}

			Date departureDate = information.get(0).getDeparture_date();
			int trainno = information.get(0).getTrains().getTrain_no();

			int count = 0;

			while (count < 6) {

				int trainInfoNo = findTrainInfoNumber(departureDate, trainno);

				if (trainInfoNo != 0)
					trainInfoNumberList.add(trainInfoNo);
				departureDate = getNextDate(departureDate);
				count++;
			}
			manager.getTransaction().commit();
			manager.close();
			return trainInfoNumberList;
		} catch (TrainInfoNumberNotFound e) {
			log.error(e);
		}
		return trainInfoNumberList;

	}

	public int findTrainInfoNumber(Date departureDate, int trainno) {
		int trainInfoNumber = 0;

		Query q = manager.createQuery(GETTRAININFO);
		q.setParameter("trainno", trainno);
		q.setParameter("departureDate", departureDate);
		List<train_info> list = q.getResultList();

		if (list.isEmpty()) {
			log.info("no train avaliable for this route on date " + departureDate);
		} else {
			trainInfoNumber = list.get(0).getTraininfonumber();
		}

		return trainInfoNumber;

	}

	public Date getNextDate(Date departureDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(departureDate);
		c.add(Calendar.DATE, 1);
		departureDate = new Date(c.getTimeInMillis());
		return departureDate;
	}

}
