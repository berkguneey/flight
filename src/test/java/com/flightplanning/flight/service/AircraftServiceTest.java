package com.flightplanning.flight.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.flightplanning.flight.model.Aircraft;
import com.flightplanning.flight.repository.AircraftRepository;
import com.flightplanning.flight.service.impl.AircraftServiceImpl;

@ExtendWith(MockitoExtension.class)
class AircraftServiceTest {

	@Mock
	AircraftRepository repository;
	@Spy
	ModelMapper mapper = new ModelMapper();
	@InjectMocks
	AircraftServiceImpl service;

	List<Aircraft> aircraftList;
	Aircraft aircraft1;
	Aircraft aircraft2;

	@BeforeEach
	public void setUp() {
		aircraft1 = new Aircraft();
		aircraft1.setId(UUID.randomUUID());
		aircraft1.setLicensePlate("XXX");

		aircraft2 = new Aircraft();
		aircraft2.setId(UUID.randomUUID());
		aircraft2.setLicensePlate("YYY");

		aircraftList = new ArrayList<>(Arrays.asList(aircraft1, aircraft2));
	}

	@Test
	public void testGetAllAircrafts() {
		when(repository.findAll()).thenReturn(aircraftList);
		assertNotNull(service.getAllAircrafts());
		assertEquals(2, aircraftList.size());
	}

}
