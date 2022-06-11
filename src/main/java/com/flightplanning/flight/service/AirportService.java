package com.flightplanning.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightplanning.flight.dto.AirportDto;

@Service
public interface AirportService {

	/**
	 * This method is used to get of all airports.
	 * 
	 * @return airport list
	 */
	List<AirportDto> getAllAirports();

}
