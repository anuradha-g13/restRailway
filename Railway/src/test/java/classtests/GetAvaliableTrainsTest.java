package classtests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.railway.helper.TrainsHelper;
import com.railway.impl.GetAvaliableTrainsImpl;

@RunWith(MockitoJUnitRunner.class)
class GetAvaliableTrainsTest {
//	private static final GetTrainDetails trainDetails = mock(GetTrainDetails.class);
//	private static final GetConnection getcon= mock(GetConnection.class);
	public GetAvaliableTrainsImpl avaliableTrains = new GetAvaliableTrainsImpl();
//
//	@Mock
//	Connection co = Mockito.mock(Connection.class);

	
//	GetConnection getCon = new GetConnection();

//	@Mock
//	public PreparedStatement st = Mockito.mock(PreparedStatement.class);
//
//	@Mock
//	public ResultSet rs = Mockito.mock(ResultSet.class);
//
//	public ArrayList<Passenger> passengerList;

//	@BeforeEach
//	public void setUp() {
//
//		try {
//			System.out.println(st);
//
//			when(co.prepareStatement(any(String.class))).thenReturn(st);
//			when(st.executeUpdate()).thenReturn(1);
//			when(rs.getInt("traininfonumber")).thenReturn(193180909);
//			when(rs.getInt(" avaliable_sleeper")).thenReturn(120);
//			when(trainDetails.getTrainData(anyInt())).thenReturn(setTrain());
//			when(rs.next()).thenReturn(true);
//			when(st.executeQuery()).thenReturn(rs);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
//
//	}

	@Test
	void avaliableTrainsTest() throws Exception {
		Date date = Date.valueOf("2019-09-09");
		List<TrainsHelper> t = avaliableTrains.getTrainsList("nagpur", "indore", date);
		TrainsHelper train=t.get(0);
		assertEquals(Date.valueOf("2019-09-10"), train.getArrivaldate());
		assertEquals(Date.valueOf("2019-09-09"), train.getDeparturedate());
		assertEquals("indore", train.getDestination());
		assertEquals(1200, train.getDistance());
		assertEquals("nagpur", train.getSource());
		
	}

	@Test
	TrainsHelper setTrain() {
		TrainsHelper trains = new TrainsHelper();
		trains.setArrivaldate(Date.valueOf("2019-09-09"));
		trains.setDeparturedate(Date.valueOf("2019-09-09"));
		trains.setDestination("indore");
		trains.setDistance(1200);
		trains.setSource("nagpur");
		trains.setTrainname("INDB HUMSAFAR EX");
		trains.setTrainno(19318);
		trains.setTrainInfoNumber(193180909);

		return trains;

	}
	
	
	


}
