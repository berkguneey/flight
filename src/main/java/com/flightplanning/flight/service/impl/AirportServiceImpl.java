package com.flightplanning.flight.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.flightplanning.flight.dto.AirportDto;
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

}
