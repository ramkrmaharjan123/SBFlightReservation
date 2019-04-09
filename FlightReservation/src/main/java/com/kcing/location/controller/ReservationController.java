package com.kcing.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcing.location.dao.FlightRepository;
import com.kcing.location.dto.ReservationRequest;
import com.kcing.location.entities.Flight;
import com.kcing.location.entities.Reservation;
import com.kcing.location.service.interfaces.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservationPage(@RequestParam("id") Long id,ModelMap modelMap) {
		
		Flight flight = flightRepository.getOne(id);
		
		modelMap.addAttribute("flight",flight);
		return "completeReservation";
	}

	@RequestMapping( value = "/completeReservation",method=RequestMethod.POST)
	public String completeReservation(@ModelAttribute ReservationRequest request,ModelMap modelMap) {
		Reservation r = reservationService.bookReservation(request);
		modelMap.addAttribute("msg","Reservation confirmed with reservation ID: "+ r.getReservationId());
		return "reservationConfirmation";
	}

}
