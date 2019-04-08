package com.kcing.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcing.location.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
