<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body onLoad="notifyUser()">
	
				<div >
					<div >
						<div >
							<h1>Indian Railways</h1>

						</div>
					</div>
					<div >
						<div >
							<form action="SearchTrains" method="get" enctype="application/json">
								<div >
									<span c>Enter Source</span> <input
										 type="text" name="source"
										placeholder="Enter a Source">
								</div>
								<div >
									<span >Enter Destination</span> <input
										 type="text" name="destination"
										placeholder="Enter a Destination">
								</div>

								<div >
									<span >Date Of Travel(DD-MM-YYYY)</span> <input
										 name="date" type="date" required>
								</div>


								<div >
									<button   type="submit">Check
										availability</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			

</body>
</html>
