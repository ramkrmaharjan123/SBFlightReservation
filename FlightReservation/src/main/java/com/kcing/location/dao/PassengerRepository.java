package com.kcing.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcing.location.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
