package classtests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.railway.Exception.TrainDetailsNotFound;
import com.railway.helper.TrainsHelper;
import com.railway.impl.GetTrainDataImpl;
class TrainDetailTest {

	GetTrainDataImpl trains=new GetTrainDataImpl();
	
	@Test
	void GetTrainDataValid() {
		TrainsHelper train= trains.getTrainData(193181209);
		 assertEquals("INDB HUMSAFAR EX",train.getTrainname());
		 assertEquals(19318,train.getTrainno());
		 assertEquals("nagpur",train.getSource());
		 assertEquals("indore",train.getDestination());
		return;
	}
	

	 @Test
	    public void nullCreateThrowsException() {
		
			        assertThrows(TrainDetailsNotFound.class,()->trains.getTrainData(1931819));

			 
		
	    }
}
