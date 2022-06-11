package com.flightplanning.flight.service;

import java.util.List;

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

}
