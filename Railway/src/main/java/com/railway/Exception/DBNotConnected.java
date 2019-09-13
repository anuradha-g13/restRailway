package com.railway.Exception;

public class DBNotConnected extends RuntimeException{

	public DBNotConnected(String message)
	{
		super(message);
	}
}
