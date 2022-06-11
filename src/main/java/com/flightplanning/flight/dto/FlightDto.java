package com.flightplanning.flight.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class FlightDto {

	@JsonIgnore
	private UUID id;
	private String code;
	@JsonIgnore
	private AirlineDto airline;
	@JsonIgnore
	private AircraftDto aircraft;
	private AirportDto source;
	private AirportDto destination;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate flightDate;
	private LocalTime flightTime;

}
