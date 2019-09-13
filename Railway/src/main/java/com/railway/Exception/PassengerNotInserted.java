package com.railway.Exception;

public class PassengerNotInserted extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public PassengerNotInserted(String message)
	{
		super(message);
	}
	
}
