package com.flightplanning.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightplanning.flight.dto.AirportDto;
import com.flightplanning.flight.service.AirportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Airport Controller")
@RestController
@RequestMapping("/api/v0/airports")
public class AirportController {

	private final AirportService service;

	@Autowired
	public AirportController(AirportService service) {
		this.service = service;
	}

	@ApiOperation(value = "Get All Airports")
	@GetMapping
	public ResponseEntity<List<AirportDto>> getAirports() {
		return new ResponseEntity<>(service.getAllAirports(), HttpStatus.OK);
	}

}
