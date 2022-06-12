package com.flightplanning.flight.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.flightplanning.flight.dto.AircraftDto;
import com.flightplanning.flight.dto.AirlineDto;
import com.flightplanning.flight.dto.AirportDto;
import com.flightplanning.flight.dto.FlightDto;
import com.flightplanning.flight.model.Flight;
import com.flightplanning.flight.repository.FlightRepository;
import com.flightplanning.flight.service.AirlineService;
import com.flightplanning.flight.service.AirportService;
import com.flightplanning.flight.service.FlightService;
import com.flightplanning.flight.util.AirportSelector;
import com.flightplanning.flight.util.FlightCodeGenerator;
import com.flightplanning.flight.util.LocalTimeGenerator;

@Service
public class FlightServiceImpl implements FlightService {

	private static final int MAX_FLIGHT_COUNT = 3;
	private final FlightRepository repository;
	private final AirlineService airlineService;
	private final AirportService airportService;
	private final ModelMapper mapper;

	public FlightServiceImpl(FlightRepository repository, AirlineService airlineService, AirportService airportService,
			ModelMapper mapper) {
		this.repository = repository;
		this.airlineService = airlineService;
		this.airportService = airportService;
		this.mapper = mapper;
	}

	@Scheduled(cron = "0 0 0 * * *") // At 00:00:00
	@Override
	public List<FlightDto> createPlan() {
		List<FlightDto> plannedFlights = new ArrayList<>();
		List<AirlineDto> airlines = airlineService.getAllAirlines();
		List<AirportDto> airports = airportService.getAllAirports();
		for (AirlineDto airline : airlines) {
			List<FlightDto> createdFlights = createFlight(airline, airline.getAircrafts(), airports);
			repository.saveAll(createdFlights.stream().map(flight -> mapper.map(flight, Flight.class))
					.collect(Collectors.toList()));
			plannedFlights.addAll(createdFlights);
		}
		return plannedFlights;
	}

	private List<FlightDto> createFlight(AirlineDto airline, List<AircraftDto> aircrafts, List<AirportDto> airports) {
		List<FlightDto> createdFlights = new ArrayList<>();
		int count = 0;
		for (AircraftDto aircraft : aircrafts) {
			if (count == MAX_FLIGHT_COUNT)
				break;
			FlightDto flight = new FlightDto();
			flight.setSource(AirportSelector.select(airports, null));
			flight.setDestination(AirportSelector.select(airports, flight.getSource()));
			flight.setCode(FlightCodeGenerator.generate(airline.getIataCode()));
			flight.setAircraft(aircraft);
			flight.setAirline(airline);
			flight.setFlightDate(LocalDate.now());
			flight.setFlightTime(LocalTimeGenerator.generate());
			createdFlights.add(flight);
			count++;
		}
		return createdFlights;
	}

}
