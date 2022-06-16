package com.flightplanning.flight.controller.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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

import com.flightplanning.flight.controller.AircraftController;
import com.flightplanning.flight.dto.AircraftDto;
import com.flightplanning.flight.service.AircraftService;

@ExtendWith(MockitoExtension.class)
class AircraftControllerTest {

	@Mock
	AircraftService service;
	@InjectMocks
	AircraftController controller;

	List<AircraftDto> aircraftList;
	AircraftDto aircraft1;
	AircraftDto aircraft2;

	@BeforeEach
	public void setUp() {
		aircraft1 = new AircraftDto();
		aircraft1.setId(UUID.randomUUID());
		aircraft1.setLicensePlate("X");

		aircraft2 = new AircraftDto();
		aircraft2.setId(UUID.randomUUID());
		aircraft2.setLicensePlate("Y");

		aircraftList = new ArrayList<>(Arrays.asList(aircraft1, aircraft2));
	}

	@Test
	public void testGetAircrafts() {
		when(service.getAllAircrafts()).thenReturn(aircraftList);
		assertNotNull(controller.getAircrafts());
	}

}
