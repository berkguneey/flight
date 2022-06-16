package com.flightplanning.flight.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.flightplanning.flight.constant.ErrorConstants;
import com.flightplanning.flight.dto.AirportDto;
import com.flightplanning.flight.exception.NoDataFoundException;
import com.flightplanning.flight.repository.AirportRepository;
import com.flightplanning.flight.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {

	private final AirportRepository repository;
	private final ModelMapper mapper;

	public AirportServiceImpl(AirportRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<AirportDto> getAllAirports() {
		return repository.findAll().stream().map(airport -> mapper.map(airport, AirportDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public AirportDto getAirportById(UUID id) {
		return mapper.map(
				repository.findById(id).orElseThrow(() -> new NoDataFoundException(ErrorConstants.AIRPORT_NOT_FOUND)),
				AirportDto.class);
	}

}
