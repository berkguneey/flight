package com.flightplanning.flight.repository;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightplanning.flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {

	@Query(value = "SELECT COUNT(*) FROM FLIGHT F WHERE ((F.SOURCE_ID = ?1 AND F.DESTINATION_ID = ?2) OR (F.DESTINATION_ID = ?1 AND F.SOURCE_ID = ?2)) AND F.FLIGHT_DATE = ?3", nativeQuery = true)
	long countFlightBySourceIdAndDestinationId(UUID sourceId, UUID destinationId, LocalDate flightDate);

}
