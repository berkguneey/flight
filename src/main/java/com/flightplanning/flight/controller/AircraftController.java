package com.flightplanning.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightplanning.flight.dto.AircraftDto;
import com.flightplanning.flight.service.AircraftService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Aircraft Controller")
@RestController
@RequestMapping("/api/v0/aircrafts")
public class AircraftController {

	private final AircraftService service;

	@Autowired
	public AircraftController(AircraftService service) {
		this.service = service;
	}

	@ApiOperation(value = "Get All Aircrafts")
	@GetMapping
	public ResponseEntity<List<AircraftDto>> getAircrafts() {
		return new ResponseEntity<>(service.getAllAircrafts(), HttpStatus.OK);
	}

}
