package com.flightplanning.flight.service;

import java.util.List;
import java.util.UUID;

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
	
	/**
	 * This method is used to get airline with using the entered id data.
	 * 
	 * @param id
	 * @return airline
	 */
	AirlineDto getAirlineById(UUID id);

}
