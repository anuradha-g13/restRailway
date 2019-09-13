package classtests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.railway.helper.PassengerHelper;
import com.railway.impl.BookTicketImpl;


@RunWith(MockitoJUnitRunner.class)

class BookTicketTest {

	public BookTicketImpl book;

	@Mock
	Connection co = Mockito.mock(Connection.class);


	@Mock
	public PreparedStatement st = Mockito.mock(PreparedStatement.class);

	@Mock
	public ResultSet rs = Mockito.mock(ResultSet.class);

	public List<PassengerHelper> passengerList;

	@BeforeEach
	public void setUp() {

		try {

			when(co.prepareStatement(any(String.class))).thenReturn(st);
			when(st.executeUpdate()).thenReturn(1);
			when(rs.getInt("avaliable_ac")).thenReturn(40);
			when(rs.getInt(" avaliable_sleeper")).thenReturn(120);
			when(rs.next()).thenReturn(true);
			when(st.executeQuery()).thenReturn(rs);

//				when(GetConnection.getMySQLConnection()).thenReturn(Mockito.mock(Connection.class));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		passengerList = setSleeperPassenger();
		book = new BookTicketImpl();

	}

	@Test
	void bookTicketTest() throws Exception {
		System.out.println("here");
		List<PassengerHelper> v=book.bookTickets(1000, setSleeperPassenger(),127230909);
		assertNotEquals(null, v);
		v=book.bookTickets(1000, setAcPassenger(),127230909);
				assertNotEquals(null, v);
		
	}

//
//	@Test
//	void testFare() {
//		CalculateFare obj = new CalculateFare();
//		assertEquals(3200, obj.getFare(127230909, "BookAC"));
//	}

	@Test
	List<PassengerHelper> setSleeperPassenger() {
		ArrayList<PassengerHelper> passengerList = new ArrayList<>();
		PassengerHelper passenger = new PassengerHelper();
		passenger.setName("test name");
		passenger.setAge(22);
		passenger.setFare(500);
		passenger.setGender("f");
		passenger.setTravelclass("S");
		passengerList.add(passenger);

		return passengerList;

	}

//	
	@Test
List<PassengerHelper> setAcPassenger() {
		ArrayList<PassengerHelper> passengerList = new ArrayList<>();
		PassengerHelper passenger = new PassengerHelper();
		passenger.setName("test name");
		passenger.setAge(22);
		passenger.setFare(500);
		passenger.setGender("m");
		passenger.setTravelclass("A");
		passengerList.add(passenger);

		return passengerList;

	}
//	
}
