package com.flightplanning.flight.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.flightplanning.flight.dto.AircraftDto;

@Service
public interface AircraftService {

	/**
	 * This method is used to get of all aircrafts.
	 * 
	 * @return aircraft list
	 */
	List<AircraftDto> getAllAircrafts();
	
	/**
	 * This method is used to get of all aircrafts that belong an airline with using the entered airline id data.
	 * 
	 * @param airlineId
	 * @return airport list
	 */
	List<AircraftDto> getAircraftsByAirlineId(UUID airlineId);
	
	/**
	 * This method is used to get aircraft with using the entered id data.
	 * 
	 * @param id
	 * @return aircraft
	 */
	AircraftDto getAircraftById(UUID id);
	
	/**
	 * This method is used to update a flight planned flag of aircraft with using the entered id data.
	 * 
	 * @param id
	 * @return aircraft
	 */
	AircraftDto updateAircraft(UUID id, boolean isFlightPlanned);

}
