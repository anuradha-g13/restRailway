package classtests;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.railway.helper.SeatsHelper;
import com.railway.service.GetSeats;


class GetSeatsTest {

	GetSeats seats = new GetSeats();

	@Test
	void GetTrainDataValid() {
		Date date = Date.valueOf("2019-09-09");
		SeatsHelper seat = seats.seats(193180909);
		assertEquals(193180909, seat.getTraininfonumber());
		assertEquals(date.toString(), seat.getDate().toString());
		assertEquals(34, seat.getAcSeats());
		assertEquals(120, seat.getSleeperSeat());
		return;
	}

	@Test
	void getTrainInfoNumberOf6DayList() {
		assertEquals(Arrays.asList(193180909, 193181009, 193181109, 193181209, 193181309),
				seats.getTrainInfoNumberOf6DayList(193180909));

		return;
	}

}
