package com.kcing.location.service.interfaces;

import com.kcing.location.dto.ReservationRequest;
import com.kcing.location.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookReservation(ReservationRequest request);

}
