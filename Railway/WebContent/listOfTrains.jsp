<%@page import="com.railway.helper.TrainsHelper"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,com.railway.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<c:choose>

<c:when test="${errormsg != null }">
<script type="text/javascript">
function alertBox() {
alert("please provide valid data");
			window.location = "index.jsp";
}
			</script>
</c:when>
<c:otherwise>
<c:choose>
<c:when test="${trains == null || trains.size() == 0 }">

<script type="text/javascript">
function alertBox() {
	alert("no trains found for this route on this date, please try a diffrent route");
	window.location = "index.jsp";
}
			</script>

</c:when>
</c:choose>
</c:otherwise>
</c:choose>
	
	<jsp:include page="JSPPages/Menu.jsp"></jsp:include>


<table class="table table-bordered table-dark">
  <thead>
    <tr>
      <th>Train Info Number</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Distance</th>
			<th>Departure Date</th>
			<th>Arrival Date</th>
			<th>Seats</th>
    </tr>
  </thead>
		<tbody>
			<c:if test="${trains.size() > 0}">
		
	<c:forEach var="i" begin="0" end="${trains.size()-1}">


			<tr>
				
				<td>
				
				${trains.get(i).getTrainInfoNumber()}
					
				</td>
				 <td>
				 ${trains.get(i).getSource()}
					
				</td>
				<td>
				 ${trains.get(i).getDestination()}
					
				</td>
				<td>
				 ${trains.get(i).getDistance()}
					
				</td>
				<td>
				 ${trains.get(i).getDeparturedate()}
					
				</td>
				<td>
				 ${trains.get(i).getArrivaldate()}
					
				</td> 
			<td><a href="SearchSeats?info=${trains.get(i).getTrainInfoNumber()}">View</a></td>
</tr>
			</c:forEach>
			</c:if>
		
		</tbody>
	</table>
	
	<script type="text/javascript">
		window.onload = alertBox();
	</script>

</body>
</html>
