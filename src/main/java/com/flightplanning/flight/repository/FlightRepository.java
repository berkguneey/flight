package com.flightplanning.flight.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightplanning.flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID>  {

}
