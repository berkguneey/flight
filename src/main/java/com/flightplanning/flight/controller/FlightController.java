package com.flightplanning.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightplanning.flight.dto.FlightDto;
import com.flightplanning.flight.service.FlightService;

@RestController
@RequestMapping("/api/v0/flights")
public class FlightController {

	private final FlightService service;

	@Autowired
	public FlightController(FlightService service) {
		this.service = service;
	}

	@GetMapping()
	public ResponseEntity<List<FlightDto>> createPlan() {
		return new ResponseEntity<>(service.createPlan(), HttpStatus.OK);
	}

}
