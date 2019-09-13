<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="BookSeat" method="POST">
		<!-- common data -->
		<input type="hidden" name="InfoNumber"
			value="<%=request.getParameter("InfoNumber")%>"> <input
			type="hidden" name="Afare"
			value="<%=request.getParameter("Afare")%>"> <input
			type="hidden" name="Sfare"
			value="<%=request.getParameter("Sfare")%>">

		<!-- row 1 -->
		<select name="gender" id="gender">
			<option value="f">Female</option>
			<option value="m">Male</option>
		</select><h4>Name</h4> <input id="name" name="name" type="text"> <h4>age</h4><input id="age"
			name="age" type="text">
		<!-- row 2 -->
		<select name="gender" id="gender">
			<option value="f">Female</option>
			<option value="m">Male</option>
		</select><h4>Name</h4> <input id="name" name="name" type="text"> <h4>age</h4> <input id="age"
			name="age" type="text">
		<!-- submit at bottom -->
		<input type="submit" name="action"
			value="<%=request.getParameter("action")%>">
	</form>

</body>
</html>