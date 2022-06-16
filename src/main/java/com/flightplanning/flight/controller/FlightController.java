package com.flightplanning.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightplanning.flight.dto.FlightDto;
import com.flightplanning.flight.dto.FlightRequestDto;
import com.flightplanning.flight.service.FlightService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Flight Controller")
@RestController
@RequestMapping("/api/v0/flights")
public class FlightController {

	private final FlightService service;

	@Autowired
	public FlightController(FlightService service) {
		this.service = service;
	}
	
	@ApiOperation(value = "Create Flight")
	@PostMapping
	public ResponseEntity<FlightDto> createFlight(@RequestBody FlightRequestDto flightRequest) {
		return new ResponseEntity<>(service.createFlight(flightRequest), HttpStatus.OK);
	}

}
