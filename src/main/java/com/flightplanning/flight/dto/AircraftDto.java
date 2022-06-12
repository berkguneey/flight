package com.flightplanning.flight.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class AircraftDto {

	private UUID id;
	private String licensePlate;
	private AircraftModelDto aircraftModel;
	private AirlineDto airline;
	//private List<FlightDto> flights; // lazy

}
