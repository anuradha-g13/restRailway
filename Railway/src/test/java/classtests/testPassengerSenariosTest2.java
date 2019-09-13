package classtests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.railway.Exception.InvalidInput;
import com.railway.helper.PassengerHelper;
import com.railway.service.SetPassengers;

class testPassengerSenariosTest2 {

	@Test
	void withValidData() {
		
		String[] name = {"testName1","testname2"};
		String[] age = {"10","20"};
		String[] gender = {"f","f"};
		String action="A";
		SetPassengers obj = new SetPassengers();
		
		ArrayList<PassengerHelper> passangerList =obj.addPassengers(name, age, gender, action);
		assertEquals("testName1",passangerList.get(1).getName());
		 assertEquals(10,passangerList.get(1).getAge());
			assertEquals("testname2",passangerList.get(0).getName());
			 assertEquals(20,passangerList.get(0).getAge());
			 
	}
	
	
	
	
//	
	@Test
	void withinValidName() {
		
		String[] name = {"","testname2"};
		String[] age = {"10","20"};
		String[] gender = {"m","f"};
		String action="A";
		SetPassengers obj = new SetPassengers();
		
		InvalidInput thrown =
		        assertThrows(InvalidInput.class,() ->obj.addPassengers(name, age, gender, action), "Expected doThing() to throw, but it didn't");

		    assertTrue(thrown.getMessage().contains("please provide name of the passenger"));
		
	}

	@Test
	void withinValidage() {
		
		String[] name = {"testname1","testname2"};
		String[] age = {"na","20"};
		String[] gender = {"m","f"};
		String action="A";
		SetPassengers obj = new SetPassengers();
		
		InvalidInput thrown =
		        assertThrows(InvalidInput.class,() ->obj.addPassengers(name, age, gender, action), "Expected doThing() to throw, but it didn't");

		    assertTrue(thrown.getMessage().contains("please provide valid age of the passenger"));
		
		
	}
	
//	
	
}
