package com.kcing.location.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcing.location.dao.FlightRepository;
import com.kcing.location.dao.PassengerRepository;
import com.kcing.location.dao.ReservationRepository;
import com.kcing.location.dto.ReservationRequest;
import com.kcing.location.entities.Flight;
import com.kcing.location.entities.Passenger;
import com.kcing.location.entities.Reservation;
import com.kcing.location.service.interfaces.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservRepository;
	
	@Override
	public Reservation bookReservation(ReservationRequest request) {
		
		
		Flight flight = flightRepository.getOne(request.getFlightId());
		
		Passenger p= new Passenger();
		p.setFirstName(request.getPassengerFirstName());
		p.setLastName(request.getPassengerLastName());
		p.setPhone(request.getPassengerPhone());
		p.setEmail(request.getPassengerEmail());
		
		Passenger saveP = passengerRepository.save(p);
		
		Reservation r = new Reservation();
		r.setCheckedIn(false);
		r.setFlight(flight);
		r.setPassenger(saveP);
		
		Reservation saveR = reservRepository.save(r);
		
		return saveR;
	}

}
