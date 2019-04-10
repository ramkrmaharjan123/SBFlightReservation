package com.kcing.flightcheckin.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcing.flightcheckin.integration.ReservationRestClient;
import com.kcing.flightcheckin.integration.dto.Reservation;
import com.kcing.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	
	@Autowired
	private ReservationRestClient reservationClient;
	
	@RequestMapping("/showCheckIn")
	public String showCheckInPage() {
		
		return "confirmCheckIn";
		
	}
	
	@RequestMapping("/checkInFlight") 
	public String checkInFlight(@RequestParam("reservationID") Long reservationID,ModelMap modelmap) {
		Reservation findReservation = reservationClient.findReservation(reservationID);
		modelmap.addAttribute("reservation",findReservation);
		return "displayReservation";
	}

//	@RequestMapping(value="/completeReservation",method=RequestMethod.POST) 
//	public String checkInFlight(@ModelAttribute("updateRequest") ReservationUpdateRequest updateRequest) {
//		updateRequest.setCheckedin(true);
//		reservationClient.updateReservationRequest(updateRequest);
//		return "checkInComplete";
//	}
	
	@RequestMapping(value="/completeReserve",method=RequestMethod.POST) 
	public String checkInFlight(@RequestParam("reservationId")Long id, @RequestParam("numOfBags")int numOfBags) {
		ReservationUpdateRequest updateRequest = new ReservationUpdateRequest();
		updateRequest.setReservationId(id);
		updateRequest.setNumOfBags(numOfBags);
		updateRequest.setCheckedin(true);
		reservationClient.updateReservationRequest(updateRequest);
		return "checkInComplete";
	}
	
}
