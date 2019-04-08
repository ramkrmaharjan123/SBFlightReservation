package com.kcing.location.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kcing.location.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDep")
	List<Flight> findFlights(@Param("departureCity")String depCity, @Param("arrivalCity")String arrivalCity,@Param("dateOfDep") Date date);

}
