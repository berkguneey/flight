package com.flightplanning.flight.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FlightDto {

	private UUID id;
	private String code;
	private AirlineDto airline;
	private AirportDto source;
	private AirportDto destination;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate flightDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime flightTime;

}
