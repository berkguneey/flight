package com.flightplanning.flight.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.flightplanning.flight.constant.ErrorConstants;
import com.flightplanning.flight.dto.AircraftDto;
import com.flightplanning.flight.dto.FlightDto;
import com.flightplanning.flight.dto.FlightRequestDto;
import com.flightplanning.flight.exception.BusinessException;
import com.flightplanning.flight.model.Aircraft;
import com.flightplanning.flight.model.Airline;
import com.flightplanning.flight.model.Airport;
import com.flightplanning.flight.model.Flight;
import com.flightplanning.flight.repository.FlightRepository;
import com.flightplanning.flight.service.AircraftService;
import com.flightplanning.flight.service.AirlineService;
import com.flightplanning.flight.service.AirportService;
import com.flightplanning.flight.service.FlightService;
import com.flightplanning.flight.util.FlightCodeGenerator;

@Service
public class FlightServiceImpl implements FlightService {

	private static final long MAX_FLIGHT_COUNT = 3L;
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

	@Override
	public FlightDto createFlight(FlightRequestDto flightRequest) {

		checkFlight(flightRequest);

		Airline airline = mapper.map(airlineService.getAirlineById(flightRequest.getAirlineId()), Airline.class);

		Flight mFlight = new Flight();
		mFlight.setCode(FlightCodeGenerator.generate(airline.getIataCode()));
		mFlight.setAircraft(mapper.map(aircraftService.getAircraftById(flightRequest.getAircraftId()), Aircraft.class));
		mFlight.setAirline(airline);
		mFlight.setSource(mapper.map(airportService.getAirportById(flightRequest.getAirportSourceId()), Airport.class));
		mFlight.setDestination(mapper.map(airportService.getAirportById(flightRequest.getAirportDestinationId()), Airport.class));
		mFlight.setFlightDate(flightRequest.getFlightDate());
		mFlight.setFlightTime(flightRequest.getFlightTime());

		aircraftService.updateAircraft(flightRequest.getAircraftId(), true);

		return mapper.map(repository.save(mFlight), FlightDto.class);
	}

	private long countFlightBySourceIdAndDestinationId(UUID sourceId, UUID destinationId, LocalDate flightDate) {
		return repository.countFlightBySourceIdAndDestinationId(sourceId, destinationId, flightDate);
	}

	private void checkFlight(FlightRequestDto flightRequest) {
		if (flightRequest.getAirportSourceId().equals(flightRequest.getAirportDestinationId())) {
			throw new BusinessException(ErrorConstants.AIRPORT_SELECTION_INVALID);
		}
		List<AircraftDto> aircrafts = aircraftService.getAircraftsByAirlineId(flightRequest.getAirlineId());
		if (!aircrafts.stream().anyMatch(a -> a.getId().equals(flightRequest.getAircraftId()))) {
			throw new BusinessException(ErrorConstants.AIRCRAFT_AIRLINE_DISMATCH);
		}
		AircraftDto aircraft = aircraftService.getAircraftById(flightRequest.getAircraftId());
		if (aircraft.isFlightPlanned()) {
			throw new BusinessException(ErrorConstants.AIRCRAFT_ALREADY_PLANNED);
		}
		if (MAX_FLIGHT_COUNT == countFlightBySourceIdAndDestinationId(flightRequest.getAirportSourceId(),
				flightRequest.getAirportDestinationId(), flightRequest.getFlightDate())) {
			throw new BusinessException(ErrorConstants.PLANNED_FLIGHT_INVALID);
		}
	}

}
