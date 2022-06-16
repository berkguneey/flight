package com.flightplanning.flight.service;

import java.util.List;
import java.util.UUID;

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
	
	/**
	 * This method is used to get airport with using the entered id data.
	 * 
	 * @param id
	 * @return airport
	 */
	AirportDto getAirportById(UUID id);

}
