package com.flightplanning.flight.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import com.flightplanning.flight.dto.FlightRequestDto;
import com.flightplanning.flight.exception.BusinessException;
import com.flightplanning.flight.model.Airline;
import com.flightplanning.flight.model.Airport;
import com.flightplanning.flight.model.Flight;
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

	FlightRequestDto flightRequest;
	List<AircraftDto> aircraftList;
	AircraftDto aircraft1;
	AircraftDto aircraft2;

	AirlineDto airline1;

	AirportDto airport1;
	AirportDto airport2;

	List<Flight> flightList;
	Flight flight1;
	Flight flight2;

	@BeforeEach
	public void setUp() {
		flightRequest = new FlightRequestDto();
		flightRequest.setAircraftId(UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"));
		flightRequest.setAirlineId(UUID.randomUUID());
		flightRequest.setAirportSourceId(UUID.randomUUID());
		flightRequest.setAirportDestinationId(UUID.randomUUID());
		flightRequest.setFlightDate(LocalDate.of(2022, 06, 17));
		flightRequest.setFlightTime(LocalTime.of(10, 0, 0));

		aircraft1 = new AircraftDto();
		aircraft1.setId(UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"));
		aircraft1.setLicensePlate("XXX");

		aircraft2 = new AircraftDto();
		aircraft2.setId(UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"));
		aircraft2.setLicensePlate("YYY");

		aircraftList = new ArrayList<>(Arrays.asList(aircraft1, aircraft2));

		airline1 = new AirlineDto();
		airline1.setId(UUID.randomUUID());
		airline1.setIataCode("XXX");
		airline1.setName("TEST1");
		airline1.setCreatedAt(LocalDateTime.now());

		airport1 = new AirportDto();
		airport1.setId(UUID.randomUUID());
		airport1.setIcaoCode("XXX");
		airport1.setIataCode("XXX");
		airport1.setName("TEST1");
		airport1.setCreatedAt(LocalDateTime.now());

		airport2 = new AirportDto();
		airport2.setId(UUID.randomUUID());
		airport2.setIcaoCode("YYY");
		airport2.setIataCode("YYY");
		airport2.setName("TEST2");
		airport2.setCreatedAt(LocalDateTime.now());

		flight1 = new Flight();
		flight1.setAirline(mapper.map(airline1, Airline.class));
		flight1.setCode("XX");
		flight1.setSource(mapper.map(airport1, Airport.class));
		flight1.setDestination(mapper.map(airport2, Airport.class));
		flight1.setFlightDate(LocalDate.of(2022, 06, 17));
		flight1.setFlightTime(LocalTime.now());
	}

	@Test
	public void testCreatePlan() {
		when(aircraftService.getAircraftsByAirlineId(any())).thenReturn(aircraftList);
		when(repository.countFlightsBySourceIdAndDestinationId(any(), any(), any(), any())).thenReturn(0L);
		when(repository.findFlightsByAircraftIdAndFlightDate(any(), any())).thenReturn(new ArrayList<>());
		when(aircraftService.getAircraftById(any())).thenReturn(aircraft1);
		when(airportService.getAirportById(any())).thenReturn(airport1);
		when(airlineService.getAirlineById(any())).thenReturn(airline1);
		when(repository.save(any())).thenReturn(flight1);
		assertNotNull(service.createFlight(flightRequest));
	}

	@Test
	public void testCreatePlan_ReturnBusinessException_1016() {
		flightRequest.setAirportSourceId(UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4d"));
		flightRequest.setAirportDestinationId(UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4d"));
		assertThrows(BusinessException.class, () -> service.createFlight(flightRequest));
	}

	@Test
	public void testCreatePlan_ReturnBusinessException_1014() {
		flightRequest.setAircraftId(UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4d"));
		when(aircraftService.getAircraftsByAirlineId(any())).thenReturn(aircraftList);
		assertThrows(BusinessException.class, () -> service.createFlight(flightRequest));
	}

	@Test
	public void testCreatePlan_ReturnBusinessException_1017() {
		when(aircraftService.getAircraftsByAirlineId(any())).thenReturn(aircraftList);
		when(repository.countFlightsBySourceIdAndDestinationId(any(), any(), any(), any())).thenReturn(3L);
		assertThrows(BusinessException.class, () -> service.createFlight(flightRequest));
	}

	@Test
	public void testCreatePlan_ReturnBusinessException_1015() {
		flight1.setFlightTime(LocalTime.of(10, 0, 0));
		when(aircraftService.getAircraftsByAirlineId(any())).thenReturn(aircraftList);
		when(repository.countFlightsBySourceIdAndDestinationId(any(), any(), any(), any())).thenReturn(0L);
		when(repository.findFlightsByAircraftIdAndFlightDate(any(), any())).thenReturn(Arrays.asList(flight1));
		assertThrows(BusinessException.class, () -> service.createFlight(flightRequest));
	}

}
