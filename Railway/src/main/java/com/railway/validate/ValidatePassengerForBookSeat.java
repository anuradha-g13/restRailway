package com.railway.validate;

import org.springframework.stereotype.Component;

import com.railway.Exception.InvalidInput;
@Component
public class ValidatePassengerForBookSeat {

	public void checkName(String[] name) {
		String errormsg = "please provide name of the passenger ";
		if (name.length == 0) {
			throw new InvalidInput(errormsg);
		} else {
			int i = 0;
			while (i < name.length) {
				if (name[i].equals("")  || name[i] == null) {
					throw new InvalidInput(errormsg +""+(i + 1));
				}
				i++;
			}
		}
	}

	public void checkAge(String[] age) {

		String errormsg = "please provide valid age of the passenger ";
		if (age.length == 0) {
			throw new InvalidInput(errormsg);
		} else {
			int i = 0;
			while (i < age.length) {
				if (age[i].equals("")  || age[i] == null) {
					throw new InvalidInput(errormsg + i + 1);
				} else {
					try {
						Integer.parseInt(age[i]);
					} catch (NumberFormatException e) {
						throw new InvalidInput(errormsg + (i + 1));
					}
				}
				i++;
			}
		}

	}

	public void checkGender(String[] gender) {

		String errormsg = "please provide valid gender of the passenger ";
		if (gender.length == 0) {
			throw new InvalidInput(errormsg);
		} else {
			int i = 0;
			while (i < gender.length) {
				if (gender[i].equals("") || gender[i] == null ) {
					System.out.println(gender[i]);
					throw new InvalidInput(errormsg + i + 1);
				} 
				i++;
			}
		}

	}

	public void checkAction(String action) {


		String errormsg = "please select AC or Sleeper seat with A or S ";
			if (action.equals("") || action == null ) {
					throw new InvalidInput(errormsg);
				} 
				
			}
	
}
