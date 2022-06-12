package com.flightplanning.flight.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class FlightRequestDto {

	private String code;
	private AirlineDto airline;
	private AircraftDto aircraft;
	private AirportDto source;
	private AirportDto destination;
	private LocalDate flightDate;
	private LocalTime flightTime;

}
