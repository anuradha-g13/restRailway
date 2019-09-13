package com.railway.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


import com.railway.connections.PersistenceManager;
import com.railway.model.tickets;
import com.railway.model.train_info;


@Component
public class GetTicketImpl {

	private final Logger log = Logger.getLogger(this.getClass());
	EntityManager manager;

	
	public int getTicket(int trainInfoNumber)
	{
		train_info info= new train_info();
		info.setTraininfonumber(trainInfoNumber);
		tickets ticket= new tickets();
		ticket.setCancle_id(0);
		ticket.setUser_id("anu_1306");
		ticket.setTrain_info(info);
		
		manager = new PersistenceManager().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(ticket);
		int ticketId= ticket.getTicket_no();
		manager.getTransaction().commit();
		manager.close();
	
		log.info("ticket created with number = " + ticketId);
		return ticketId;
	}
	
}
