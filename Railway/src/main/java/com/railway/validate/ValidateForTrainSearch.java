package com.railway.validate;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.railway.Exception.InvalidInput;


@Component
public class ValidateForTrainSearch {

	
	public void checkSourceDestination(String city)
	{
		System.out.println("hiiiiiii"+city);
		if(city.equals(null))
		{
			throw new InvalidInput("please provide valid name ");
		}else if(city.equals(""))
		{
			throw new InvalidInput("please provide valid name");
		}
		
	}
	
	public void checkDate(String date)
	{
		
	try {
		if(date.equals(null))
		{
			throw new InvalidInput("please provide a valid date");
		}
		Date.valueOf(date);
	}catch(IllegalArgumentException e)
	{
		throw new InvalidInput("please provide a valid date");
	}
		
		
	}
}
