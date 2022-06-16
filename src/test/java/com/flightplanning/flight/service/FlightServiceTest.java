package com.flightplanning.flight.service;

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

import com.flightplanning.flight.dto.AircraftDto;
import com.flightplanning.flight.dto.AirlineDto;
import com.flightplanning.flight.dto.AirportDto;
import com.flightplanning.flight.repository.FlightRepository;
import com.flightplanning.flight.service.impl.AircraftServiceImpl;
import com.flightplanning.flight.service.impl.AirlineServiceImpl;
import com.flightplanning.flight.service.impl.AirportServiceImpl;
import com.flightplanning.flight.service.impl.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

	@Mock
	FlightRepository repository;
	@Mock
	AirlineServiceImpl airlineService;
	@Mock
	AirportServiceImpl airportService;
	@Mock
	AircraftServiceImpl aircraftService;
	@Spy
	ModelMapper mapper = new ModelMapper();
	@InjectMocks
	FlightServiceImpl service;

	List<AircraftDto> aircraftList;
	AircraftDto aircraft1;
	AircraftDto aircraft2;
	List<AirlineDto> airlineList;
	AirlineDto airline1;
	AirlineDto airline2;
	List<AirportDto> airportList;
	AirportDto airport1;
	AirportDto airport2;

	@BeforeEach
	public void setUp() {
		aircraft1 = new AircraftDto();
		aircraft1.setId(UUID.randomUUID());
		aircraft1.setLicensePlate("XXX");

		aircraft2 = new AircraftDto();
		aircraft2.setId(UUID.randomUUID());
		aircraft2.setLicensePlate("YYY");

		aircraftList = new ArrayList<>(Arrays.asList(aircraft1, aircraft2));

		airline1 = new AirlineDto();
		airline1.setId(UUID.randomUUID());
		airline1.setIataCode("XXX");
		airline1.setName("TEST1");
		airline1.setCreatedAt(LocalDateTime.now());

		airline2 = new AirlineDto();
		airline2.setId(UUID.randomUUID());
		airline2.setIataCode("YYY");
		airline2.setName("TEST2");
		airline2.setCreatedAt(LocalDateTime.now());

		airlineList = new ArrayList<>(Arrays.asList(airline1, airline2));

		airport1 = new AirportDto();
		airport1.setId(UUID.randomUUID());
		airport1.setIcaoCode("XXX");
		airport1.setIataCode("XXX");
		airport1.setName("TEST1");
		airport1.setCreatedAt(LocalDateTime.now());

		airport2 = new AirportDto();
		airport2.setId(UUID.randomUUID());
		airport2.setIcaoCode("XXX");
		airport2.setIataCode("XXX");
		airport2.setName("TEST1");
		airport2.setCreatedAt(LocalDateTime.now());

		airportList = new ArrayList<>(Arrays.asList(airport1, airport2));
	}

	@Test
	public void testCreatePlan() {
		
	}

}
