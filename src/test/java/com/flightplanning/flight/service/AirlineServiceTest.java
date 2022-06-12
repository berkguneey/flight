package com.flightplanning.flight.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.flightplanning.flight.model.Airline;
import com.flightplanning.flight.repository.AirlineRepository;
import com.flightplanning.flight.service.impl.AirlineServiceImpl;

@ExtendWith(MockitoExtension.class)
class AirlineServiceTest {

	@Mock
	AirlineRepository repository;
	@Spy
	ModelMapper mapper = new ModelMapper();
	@InjectMocks
	AirlineServiceImpl service;

	List<Airline> airlineList;
	Airline airline1;
	Airline airline2;

	@BeforeEach
	public void setUp() {
		airline1 = new Airline();
		airline1.setId(UUID.randomUUID());
		airline1.setIataCode("XXX");
		airline1.setName("TEST1");
		airline1.setCreatedAt(LocalDateTime.now());

		airline2 = new Airline();
		airline2.setId(UUID.randomUUID());
		airline2.setIataCode("YYY");
		airline2.setName("TEST2");
		airline2.setCreatedAt(LocalDateTime.now());

		airlineList = new ArrayList<>(Arrays.asList(airline1, airline2));
	}

	@Test
	public void testGetAllAirlines() {
		when(repository.findAll()).thenReturn(airlineList);
		assertNotNull(service.getAllAirlines());
		assertEquals(2, airlineList.size());
	}

}
