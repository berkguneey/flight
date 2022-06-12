package com.flightplanning.flight.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class AirportDto {

	private UUID id;
	private String icaoCode;
	private String iataCode;
	private String name;
	private LocalDateTime createdAt;
	private CountryDto country;

}
