package com.flightplanning.flight.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AirportDto {

	private UUID id;
	private String icaoCode;
	private String iataCode;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	private CountryDto country;

}
