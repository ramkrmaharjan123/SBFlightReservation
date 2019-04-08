<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Flights</title>
</head>
<body>
<h2>Find Flights</h2>
<form action="findFlights" method="post">
Departure City:<input type="text" name="departureCity"/>
Arrival City:<input type="text" name="arrivalCity"/>
Date of Departure:<input type="text" name="departureDate"/>
<input type="submit" value ="Search"/>
</form>
</body>
</html>