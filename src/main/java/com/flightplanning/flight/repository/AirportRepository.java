package com.flightplanning.flight.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightplanning.flight.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, UUID> {

}
