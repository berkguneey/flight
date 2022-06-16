package com.flightplanning.flight.service;

import org.springframework.stereotype.Service;

import com.flightplanning.flight.dto.FlightDto;
import com.flightplanning.flight.dto.FlightRequestDto;

@Service
public interface FlightService {

	/**
	 * This method is used to insert a new flight to the system.
	 * 
	 * @param flightRequest
	 * @return flight
	 */
	FlightDto createFlight(FlightRequestDto flightRequest);

}
