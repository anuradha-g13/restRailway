<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList,com.railway.helper.*"%>
<%@page import="com.railway.helper.TrainsHelper"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
		function alertBox() {
	<%
			if (request.getAttribute("errorMsg") != null) {
			%>
				
		alert(request.getAttribute("errormsg"));
			window.location = "index.jsp";
	<%}%>
		}
	</script>
	<jsp:include page="JSPPages/Menu.jsp"></jsp:include>


	<table>

		<tr>
			<th>
				<h4>Passenger Name</h4>
			</th>
			<th>
				<h4>PNR Number</h4>
			</th>
			<th>
				<h4>Fare</h4>
			</th>
		</tr>
		<c:if test="${pnr.size() > 0}">

			<h3>Ticket Booked SuccessFully with Ticket Number
				${pnr.get(0).getTicketno()}</h3>
				
			<c:forEach var="i" begin="0" end="${pnr.size()-1}">

				<tr>
					<td>${pnr.get(i).getName()}</td>

					<td>${pnr.get(i).getPnrno()}</td>
					<td>${pnr.get(i).getFare()}</td>
				</tr>

			</c:forEach>
		</c:if>
	</table>

	<script type="text/javascript">
		window.onload = alertBox();
	</script>
</body>
</html>