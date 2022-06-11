package com.flightplanning.flight.dto;

import java.util.Set;
import java.util.UUID;

import lombok.Data;

@Data
public class AircraftModelDto {

	private UUID id;
	private String icaoCode;
	private String iataCode;
	private String model;
	//private List<AircraftDto> aircrafts;

}
