package com.flightplanning.flight.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AirlineDto {

	private UUID id;
	private String name;
	private String iataCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	//private List<AircraftDto> aircrafts; // lazy
	//private List<FlightDto> flights; // lazy
	
}
