package com.flightplanning.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightplanning.flight.dto.AirlineDto;

@Service
public interface AirlineService {

	/**
	 * This method is used to get of all airlines.
	 * 
	 * @return airline list
	 */
	List<AirlineDto> getAllAirlines();

}
