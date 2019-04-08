package com.kcing.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcing.location.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
