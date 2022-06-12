package com.flightplanning.flight.controller.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightplanning.flight.controller.FlightController;
import com.flightplanning.flight.dto.AirportDto;
import com.flightplanning.flight.dto.FlightDto;
import com.flightplanning.flight.service.FlightService;

@ExtendWith(MockitoExtension.class)
class FlightControllerTest {

	@Mock
	FlightService service;
	@InjectMocks
	FlightController controller;

	List<FlightDto> flightList;
	FlightDto flight1;
	FlightDto flight2;

	@BeforeEach
	public void setUp() {

		flight1 = new FlightDto();
		flight1.setCode("XX-123");
		flight1.setSource(new AirportDto());
		flight1.setDestination(new AirportDto());
		flight1.setFlightDate(LocalDate.now());
		flight1.setFlightTime(LocalTime.now());

		flight2 = new FlightDto();
		flight2.setCode("XY-123");
		flight2.setSource(new AirportDto());
		flight2.setDestination(new AirportDto());
		flight2.setFlightDate(LocalDate.now());
		flight2.setFlightTime(LocalTime.now());

		flightList = new ArrayList<>(Arrays.asList(flight1, flight2));
	}

	@Test
	public void testCreatePlan() {
		when(service.createPlan()).thenReturn(flightList);
		assertNotNull(controller.createPlan());
	}

}
