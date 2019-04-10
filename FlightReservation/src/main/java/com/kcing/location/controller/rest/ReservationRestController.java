package com.kcing.location.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcing.location.dao.ReservationRepository;
import com.kcing.location.dto.ReservationUpdateRequest;
import com.kcing.location.entities.Reservation;

@RestController
public class ReservationRestController {
	 
	@Autowired
	private ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		
		return reservationRepository.getOne(id);
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		Reservation res= reservationRepository.getOne(request.getReservationId());
		res.setCheckedIn(request.getCheckedin());
		res.setNumberOfBags(request.getNumOfBags());
		
		Reservation result = reservationRepository.save(res);
		return result;
		
	}
}
