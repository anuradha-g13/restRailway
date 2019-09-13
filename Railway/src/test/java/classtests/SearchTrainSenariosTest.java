package classtests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.railway.Exception.InvalidInput;
import com.railway.helper.TrainsHelper;
import com.railway.service.SearchTrain;

class SearchTrainSenariosTest {

	@Test
	void withValidData() {

		SearchTrain obj = new SearchTrain();
		List<TrainsHelper> trainList = obj.searchTrainsBySrcDestinatioDate("nagpur", "indore", "2019-09-09");
		assertEquals("INDB HUMSAFAR EX", trainList.get(0).getTrainname());
		assertEquals(19318, trainList.get(0).getTrainno());
		assertEquals("nagpur", trainList.get(0).getSource());
		assertEquals("indore", trainList.get(0).getDestination());

	}

	@Test
	void withinValidSource() {

		SearchTrain obj = new SearchTrain();
		InvalidInput thrown = assertThrows(InvalidInput.class,
				() -> obj.searchTrainsBySrcDestinatioDate("", "indore", "2019-09-09"),
				"Expected doThing() to throw, but it didn't");

		assertTrue(thrown.getMessage().contains("please provide valid"));

	}

	@Test
	void withinValidDestination() {

		SearchTrain obj = new SearchTrain();
		InvalidInput thrown = assertThrows(InvalidInput.class,
				() -> obj.searchTrainsBySrcDestinatioDate("nagpur", "", "2019-09-09"),
				"Expected doThing() to throw, but it didn't");

		assertTrue(thrown.getMessage().contains("please provide valid "));

	}

	@Test
	void withinValidDate() {

		SearchTrain obj = new SearchTrain();

		InvalidInput thrown = assertThrows(InvalidInput.class,
				() -> obj.searchTrainsBySrcDestinatioDate("nagpur", "indore", null),
				"Expected doThing() to throw, but it didn't");
		System.out.println(thrown.getMessage());
		assertTrue(thrown.getMessage().contains("please provide a valid date"));

	}

}
