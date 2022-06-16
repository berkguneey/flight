package com.flightplanning.flight.controller.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightplanning.flight.controller.FlightController;
import com.flightplanning.flight.dto.AirportDto;
import com.flightplanning.flight.dto.FlightDto;
import com.flightplanning.flight.dto.FlightRequestDto;
import com.flightplanning.flight.service.FlightService;

@ExtendWith(MockitoExtension.class)
class FlightControllerTest {

	@Mock
	FlightService service;
	@InjectMocks
	FlightController controller;

	FlightRequestDto flightRequest;
	FlightDto flight1;

	@BeforeEach
	public void setUp() {
		flightRequest = new FlightRequestDto();
		flightRequest.setAirlineId(UUID.randomUUID());
		flightRequest.setAircraftId(UUID.randomUUID());
		flightRequest.setAirportSourceId(UUID.randomUUID());
		flightRequest.setAirportDestinationId(UUID.randomUUID());
		flightRequest.setFlightDate(LocalDate.now());
		flightRequest.setFlightTime(LocalTime.now());

		flight1 = new FlightDto();
		flight1.setCode("XX-123");
		flight1.setSource(new AirportDto());
		flight1.setDestination(new AirportDto());
		flight1.setFlightDate(LocalDate.now());
		flight1.setFlightTime(LocalTime.now());
	}

	@Test
	public void testCreateFlight() {
		when(service.createFlight(any(FlightRequestDto.class))).thenReturn(flight1);
		assertNotNull(controller.createFlight(flightRequest));
	}

}
