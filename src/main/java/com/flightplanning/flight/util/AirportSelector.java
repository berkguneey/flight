package com.flightplanning.flight.util;

import java.util.List;
import java.util.Random;

import com.flightplanning.flight.dto.AirportDto;

public class AirportSelector {

	public static AirportDto select(List<AirportDto> airports, AirportDto excludeElement) {
		List<AirportDto> clone = airports;
		final Random randomGenerator = new Random();
		clone.remove(excludeElement);
		int index = randomGenerator.nextInt(airports.size());
		return clone.get(index);
	}

}
