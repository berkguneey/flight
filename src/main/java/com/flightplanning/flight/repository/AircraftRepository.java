package com.flightplanning.flight.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightplanning.flight.model.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, UUID> {
	
	List<Aircraft> findAircraftsByAirlineId(UUID airlineId);

}
