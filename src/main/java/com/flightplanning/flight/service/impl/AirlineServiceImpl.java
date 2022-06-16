package com.flightplanning.flight.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.flightplanning.flight.constant.ErrorConstants;
import com.flightplanning.flight.dto.AirlineDto;
import com.flightplanning.flight.exception.NoDataFoundException;
import com.flightplanning.flight.repository.AirlineRepository;
import com.flightplanning.flight.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {

	private final AirlineRepository repository;
	private final ModelMapper mapper;

	public AirlineServiceImpl(AirlineRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<AirlineDto> getAllAirlines() {
		return repository.findAll().stream().map(airline -> mapper.map(airline, AirlineDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public AirlineDto getAirlineById(UUID id) {
		return mapper.map(
				repository.findById(id).orElseThrow(() -> new NoDataFoundException(ErrorConstants.AIRLINE_NOT_FOUND)),
				AirlineDto.class);
	}

}
