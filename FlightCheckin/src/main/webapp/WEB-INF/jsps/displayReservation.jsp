<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check In</title>
</head>
<body>

<h2> Flight Information</h2>
Airline: ${reservation.flight.operatingAirlines}<br/>
Departure City: ${reservation.flight.departureCity}<br/>
ArrivalCity: ${reservation.flight.arrivalCity}<br/>
Date of Departure: ${reservation.flight.dateOfDeparture}<br/>


<h2>Passenger Details</h2>
<pre>
First Name:${reservation.passenger.firstName }
Last Name:${reservation.passenger.lastName }
Email Address:${reservation.passenger.email }
Phone:${reservation.passenger.phone }
</pre>

<form action ="completeReserve" method="post">
<input type="hidden" name="reservationId" value="${reservation.reservationId}"/>
Number of bags you want to check in . 
<input type="text" name="numOfBags"/>
<input type="submit" value ="confirm"/>

</form>

</body>
</html>