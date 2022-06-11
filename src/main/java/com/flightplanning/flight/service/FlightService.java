package com.flightplanning.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightplanning.flight.dto.FlightDto;

@Service
public interface FlightService {

	/**
	 * This method is used to creating a daily flight plan.
	 * 
	 * @return flight list
	 */
	List<FlightDto> createPlan();

}
