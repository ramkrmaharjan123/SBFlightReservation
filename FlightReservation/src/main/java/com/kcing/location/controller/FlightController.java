package com.kcing.location.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcing.location.dao.FlightRepository;
import com.kcing.location.entities.Flight;

@Controller
public class FlightController {
	
	
	@Autowired
	private FlightRepository flightRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	@RequestMapping(value="/findFlights" ,method=RequestMethod.POST)
	public String findFlights(@RequestParam("departureCity") String depCity,@RequestParam("arrivalCity") String arrivalCity,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date date,ModelMap modelMap) {
		
		logger.info(">>FlightFlights:");
		List<Flight> flights = flightRepository.findFlights(depCity,arrivalCity,date);
		modelMap.addAttribute("flights",flights);
		return "displayFlights";
	}

	@RequestMapping(value="/admin/showAddFlights" )
	public String showAddFlights() {
		
		logger.info(">>showAddFlights:");
		return "addFlights";
	}
}
