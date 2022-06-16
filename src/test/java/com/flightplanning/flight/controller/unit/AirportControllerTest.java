package com.flightplanning.flight.controller.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightplanning.flight.controller.AirportController;
import com.flightplanning.flight.dto.AirportDto;
import com.flightplanning.flight.service.AirportService;

@ExtendWith(MockitoExtension.class)
class AirportControllerTest {

	@Mock
	AirportService service;
	@InjectMocks
	AirportController controller;

	List<AirportDto> airportList;
	AirportDto airport1;
	AirportDto airport2;

	@BeforeEach
	public void setUp() {
		airport1 = new AirportDto();
		airport1.setId(UUID.randomUUID());
		airport1.setCreatedAt(LocalDateTime.now());

		airport2 = new AirportDto();
		airport2.setId(UUID.randomUUID());
		airport2.setCreatedAt(LocalDateTime.now());

		airportList = new ArrayList<>(Arrays.asList(airport1, airport2));
	}

	@Test
	public void testGetAirports() {
		when(service.getAllAirports()).thenReturn(airportList);
		assertNotNull(controller.getAirports());
	}

}
