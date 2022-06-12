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

import com.flightplanning.flight.model.Airport;
import com.flightplanning.flight.repository.AirportRepository;
import com.flightplanning.flight.service.impl.AirportServiceImpl;

@ExtendWith(MockitoExtension.class)
class AirportServiceTest {

	@Mock
	AirportRepository repository;
	@Spy
	ModelMapper mapper = new ModelMapper();
	@InjectMocks
	AirportServiceImpl service;

	List<Airport> airportList;
	Airport airport1;
	Airport airport2;

	@BeforeEach
	public void setUp() {
		airport1 = new Airport();
		airport1.setId(UUID.randomUUID());
		airport1.setIcaoCode("XXX");
		airport1.setIataCode("XXX");
		airport1.setName("TEST1");
		airport1.setCreatedAt(LocalDateTime.now());

		airport2 = new Airport();
		airport2.setId(UUID.randomUUID());
		airport2.setIcaoCode("XXX");
		airport2.setIataCode("XXX");
		airport2.setName("TEST1");
		airport2.setCreatedAt(LocalDateTime.now());

		airportList = new ArrayList<>(Arrays.asList(airport1, airport2));
	}

	@Test
	public void testGetAllAirports() {
		when(repository.findAll()).thenReturn(airportList);
		assertNotNull(service.getAllAirports());
		assertEquals(2, airportList.size());
	}

}
