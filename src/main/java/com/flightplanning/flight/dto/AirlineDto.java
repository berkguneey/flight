package com.flightplanning.flight.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class AirlineDto {

	private UUID id;
	private String name;
	private String iataCode;
	private LocalDateTime createdAt;
	private List<AircraftDto> aircrafts ;
	//private List<FlightDto> flights ;
	
}
