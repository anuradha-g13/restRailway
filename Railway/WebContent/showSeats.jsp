<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList, com.railway.helper.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="JSPPages/Menu.jsp"></jsp:include>
	<%
		TrainsHelper train = (TrainsHelper) request.getAttribute("train");
		ArrayList<SeatsHelper> avaliableSeats = (ArrayList<SeatsHelper>) request.getAttribute("seats");
	%>

	<table border="1" cellpadding="5" cellspacing="1">

		<tr>

			<th>Train Number</th>
			<th>Train Name</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Distance</th>

		</tr>
		<tr>
			<td>
			
			${train.getTrainno()}
				
			</td>
			<td>
			${train.getTrainname()}
				
			</td>
			<td>
			${train.getSource()}
				
			</td>
			<td>
			${train.getDestination()}
				
			</td>
			<td>
			${train.getDistance()}
				
			</td>
		</tr>
		<c:forEach var="i" begin="0" end="${seats.size()-1}">
		
		
		<tr>
			<table frame="box">
				<tr style="border: thin;">

					<th>Date of Train Departure</th>
					<th>AC</th>
					<th>Sleeper</th>
				</tr>

				<tr>
					<td><input value="${seats.get(i).getDate() }" disabled></td>

					<td><input value="${seats.get(i).getAcSeats()}" disabled></td>

					<td><input value="${seats.get(i).getSleeperSeat()}" disabled>

					</td>
				</tr>

				<tr height=30px>
					<td>
						<h5>AC Fare</h5>
					</td>
					<td colspan="2">
						<form action="AddPassenger" method="post">
							<table>
								<tr>
									<td><input type="hidden" name="InfoNumber"
										value="${seats.get(i).getTraininfonumber()}"> <input
										name="Afare" value="${seats.get(i).getAcFare()}"> <input
										type="submit" name="action" value="BookAC"></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<h5>Sleeper Fare</h5>
					</td>
					<td colspan="2">
						<form action="AddPassenger" method="Post">
							<table>
								<tr>
									<td><input type="hidden" name="InfoNumber"
										value="${seats.get(i).getTraininfonumber()}"> <input
										name="Sfare" value="${seats.get(i).getSleeperFare()}"> <input
										type="submit" name="action" value="BookSleeper"></td>
								</tr>
							</table>
						</form>
				</tr>


				</td>

				</tr>

			</table>
		</tr>
		
		</c:forEach>
	

	</table>
</body>
</html>