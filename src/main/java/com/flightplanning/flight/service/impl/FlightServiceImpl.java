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
import com.flightplanning.flight.dto.FlightRequestDto;
import com.flightplanning.flight.model.Flight;
import com.flightplanning.flight.repository.FlightRepository;
import com.flightplanning.flight.service.AircraftService;
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
	private final AircraftService aircraftService;
	private final ModelMapper mapper;

	public FlightServiceImpl(FlightRepository repository, AirlineService airlineService, AirportService airportService,
			AircraftService aircraftService, ModelMapper mapper) {
		this.repository = repository;
		this.airlineService = airlineService;
		this.airportService = airportService;
		this.aircraftService = aircraftService;
		this.mapper = mapper;
	}

	@Scheduled(cron = "0 0 0 * * *") // At 00:00:00
	@Override
	public List<FlightDto> createPlan() {
		List<FlightDto> plannedFlights = new ArrayList<>();
		List<AirlineDto> airlines = airlineService.getAllAirlines();
		List<AirportDto> airports = airportService.getAllAirports();
		for (AirlineDto airline : airlines) {
			List<FlightRequestDto> createdFlights = createFlight(airline,
					aircraftService.getAircraftsByAirlineId(airline.getId()), airports);
			List<Flight> flightList = repository.saveAll(createdFlights.stream()
					.map(flight -> mapper.map(flight, Flight.class)).collect(Collectors.toList()));
			plannedFlights.addAll(flightList.stream().map(flight -> mapper.map(flight, FlightDto.class))
					.collect(Collectors.toList()));
		}
		return plannedFlights;
	}

	private List<FlightRequestDto> createFlight(AirlineDto airline, List<AircraftDto> aircrafts,
			List<AirportDto> airports) {
		List<FlightRequestDto> createdFlights = new ArrayList<>();
		int count = 0;
		for (AircraftDto aircraft : aircrafts) {
			if (count == MAX_FLIGHT_COUNT)
				break;
			FlightRequestDto flightRequest = new FlightRequestDto();
			flightRequest.setSource(AirportSelector.select(airports, null));
			flightRequest.setDestination(AirportSelector.select(airports, flightRequest.getSource()));
			flightRequest.setCode(FlightCodeGenerator.generate(airline.getIataCode()));
			flightRequest.setAircraft(aircraft);
			flightRequest.setAirline(airline);
			flightRequest.setFlightDate(LocalDate.now());
			flightRequest.setFlightTime(LocalTimeGenerator.generate());
			createdFlights.add(flightRequest);
			count++;
		}
		return createdFlights;
	}

	@Override
	public FlightDto createFlight(FlightRequestDto flightRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
