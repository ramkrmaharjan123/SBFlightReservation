<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Flights</title>
</head>
<body>

<h2> Displaying Flights</h2>
<table>
<thead>
<tr>
<th>Airlines</th>
<th>From</th>
<th>To</th>
<th>DepartureTime </th>
</tr>
</thead>

<tbody>
<c:forEach items = "${flights}" var="flight">
<tr>
<td>${flight.operatingAirlines} </td>
<td>${flight.departureCity } </td>
<td>${flight.arrivalCity} </td>
<td>${flight.estimatedDepartureTime} </td>
<td><a href="showCompleteReservation?id=${flight.flightId}">Select</a> </td>

</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>