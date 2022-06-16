package com.flightplanning.flight.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.flightplanning.flight.constant.ErrorConstants;
import com.flightplanning.flight.dto.AircraftDto;
import com.flightplanning.flight.exception.NoDataFoundException;
import com.flightplanning.flight.model.Aircraft;
import com.flightplanning.flight.repository.AircraftRepository;
import com.flightplanning.flight.service.AircraftService;

@Service
public class AircraftServiceImpl implements AircraftService {

	private final AircraftRepository repository;
	private final ModelMapper mapper;

	public AircraftServiceImpl(AircraftRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<AircraftDto> getAllAircrafts() {
		return repository.findAll().stream().map(aircraft -> mapper.map(aircraft, AircraftDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<AircraftDto> getAircraftsByAirlineId(UUID airlineId) {
		return repository.findAircraftsByAirlineId(airlineId).stream()
				.map(aircraft -> mapper.map(aircraft, AircraftDto.class)).collect(Collectors.toList());
	}

	@Override
	public AircraftDto getAircraftById(UUID id) {
		return mapper.map(
				repository.findById(id).orElseThrow(() -> new NoDataFoundException(ErrorConstants.AIRCRAFT_NOT_FOUND)),
				AircraftDto.class);
	}

	@Override
	public AircraftDto updateAircraft(UUID id, boolean isFlightPlanned) {
		Aircraft mAircraft = mapper.map(getAircraftById(id), Aircraft.class);
		mAircraft.setFlightPlanned(isFlightPlanned);
		return mapper.map(repository.save(mAircraft), AircraftDto.class);
	}

}
