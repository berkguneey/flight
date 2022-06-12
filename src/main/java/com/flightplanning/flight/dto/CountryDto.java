package com.flightplanning.flight.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CountryDto {

	private UUID id;
	private String name;
	private String iso2;
	private String iso3;
	//private List<AirportDto> airports;

}
