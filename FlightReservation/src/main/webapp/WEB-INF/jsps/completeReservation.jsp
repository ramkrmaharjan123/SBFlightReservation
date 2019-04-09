<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>

<h2> Complete Reservation</h2>
Airline: ${flight.operatingAirlines}<br/>
Departure City: ${flight.departureCity}<br/>
ArrivalCity: ${flight.arrivalCity}<br/>
Date of Departure: ${flight.dateOfDeparture}<br/>

<form action ="completeReservation" method="post">
<h2>Passenger Details</h2>
<pre>
First Name:<input type="text" name="passengerFirstName"/>
Last Name:<input type="text" name="passengerLastName"/>
Email Address:<input type="text" name="passengerEmail"/>
Phone:<input type="text" name="passengerPhone"/>
</pre>
<pre>
<h2>Card Details</h2>
Name on the Card:<input type="text" name="nameOnTheCARD"/>
CardNo:<input type="text" name="cardNumber"/>
Expiration Date:<input type="text" name="expirationDate"/>
Three digit CVVcode:<input type="text" name="securityCode"/>

<input type="hidden" name="flightId" value="${flight.flightid}"/>

<input type="submit" value ="confirm"/>
</pre>

</form>

</body>
</html>