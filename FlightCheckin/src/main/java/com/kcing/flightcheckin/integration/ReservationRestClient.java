package com.kcing.flightcheckin.integration;

import com.kcing.flightcheckin.integration.dto.Reservation;
import com.kcing.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservationRequest(ReservationUpdateRequest updateRequest);
}
