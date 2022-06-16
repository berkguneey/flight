package com.flightplanning.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightplanning.flight.dto.AirlineDto;
import com.flightplanning.flight.service.AirlineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Airline Controller")
@RestController
@RequestMapping("/api/v0/airlines")
public class AirlineController {

	private final AirlineService service;

	@Autowired
	public AirlineController(AirlineService service) {
		this.service = service;
	}

	@ApiOperation(value = "Get All Airlines")
	@GetMapping
	public ResponseEntity<List<AirlineDto>> getAirlines() {
		return new ResponseEntity<>(service.getAllAirlines(), HttpStatus.OK);
	}

}
