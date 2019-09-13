package com.railway.helper;

import java.util.List;

public class PassengerWraper {
	private List<PassengersDetailHelper> Passenger;

   
    public List<PassengersDetailHelper> getPassenger() {
        return Passenger;
    }

    /**
     * @param persons the persons to set
     */
    public void setPassenger(List<PassengersDetailHelper> Passenger) {
        this.Passenger = Passenger;
    }
}
