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

import com.flightplanning.flight.controller.AirlineController;
import com.flightplanning.flight.dto.AirlineDto;
import com.flightplanning.flight.service.AirlineService;

@ExtendWith(MockitoExtension.class)
class AirlineControllerTest {

	@Mock
	AirlineService service;
	@InjectMocks
	AirlineController controller;

	List<AirlineDto> airlineList;
	AirlineDto airline1;
	AirlineDto airline2;

	@BeforeEach
	public void setUp() {
		airline1 = new AirlineDto();
		airline1.setId(UUID.randomUUID());
		airline1.setCreatedAt(LocalDateTime.now());

		airline2 = new AirlineDto();
		airline2.setId(UUID.randomUUID());
		airline2.setCreatedAt(LocalDateTime.now());

		airlineList = new ArrayList<>(Arrays.asList(airline1, airline2));
	}

	@Test
	public void testGetAirlines() {
		when(service.getAllAirlines()).thenReturn(airlineList);
		assertNotNull(controller.getAirlines());
	}

}
