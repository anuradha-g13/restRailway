package com.railway.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.railway.helper.SeatsHelper;


@Component
public class CalculateFare {
	private final Logger log = Logger.getLogger(this.getClass());

	int acRate = 2;
	int sleeperRate = 1;

	public SeatsHelper getFare(int distance, SeatsHelper seat) {
		seat.setAcFare(getAcFare(distance));
		seat.setSleeperFare(getSleeperFare(distance));
		return seat;

	}

	public int getAcFare(int distance) {
		return distance * acRate;
	}

	public int getSleeperFare(int distance) {
		return distance * sleeperRate;
	}

//	public int getFare(int infoNumber, String action) {
//		String sqlQuery = "select distance from trains where train_no=(select train_no from train_info where traininfonumber=?)";
//		
//		int fare = 0;
//		try (Connection con = GetConnection.getMySQLConnection();
//				PreparedStatement st = con.prepareStatement(sqlQuery);) {
//			st.setInt(1, infoNumber);
//			
//			ResultSet rs = st.executeQuery();
//			if(rs.next())
//			{
//			int distance = rs.getInt("distance");
//			
//			if (action.equals("BookAC")) {
//				fare = getAcFare(distance);
//			} else {
//				fare = getSleeperFare(distance);
//
//			}
//			}
//
//		} catch (SQLException e) {
//			log.info("problem while getting fare");
//			log.error(e);
//		}
//		return fare;
//	}

//	public int updateFareInTicket(int totalFare, int ticketno) {
//		int success = 0;
//
//		String sqlQuery = "update tickets set fare=? where ticket_no=?";
//		try (Connection con = GetConnection.getMySQLConnection();
//				PreparedStatement st = con.prepareStatement(sqlQuery);) {
//			st.setInt(1, totalFare);
//			st.setInt(2, ticketno);
//
//			success = st.executeUpdate();
//			if (success != 0) {
//				log.info("ticket fare updated successfullt");
//			} else {
//				log.info("updated fare count is 0");
//
//			}
//
//		} catch (SQLException e) {
//			log.info("problem while executing query for update fare");
//			log.error(e);
//		}
//		return success;
//
//	}
}
