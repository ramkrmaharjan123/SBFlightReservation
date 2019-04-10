package com.kcing.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kcing.flightcheckin.integration.dto.Reservation;
import com.kcing.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String FLIGHT_SERVICE_URL = "http://localhost:8080/flightWEB/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		
		RestTemplate template = new RestTemplate();
		Reservation r = template.getForObject(FLIGHT_SERVICE_URL+id, Reservation.class);
		return r;
	}

	@Override
	public Reservation updateReservationRequest(ReservationUpdateRequest updateRequest) {
		RestTemplate template = new RestTemplate();
		Reservation r = template.postForObject(FLIGHT_SERVICE_URL, updateRequest, Reservation.class);
		return r;
	}

}
