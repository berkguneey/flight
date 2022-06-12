package com.flightplanning.flight.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.flightplanning.flight.dto.AirportDto;

public class AirportSelector {

	public static AirportDto select(List<AirportDto> airports, AirportDto excludeElement) {
		List<AirportDto> copy = new ArrayList<>(airports);
		final Random randomGenerator = new Random();
		copy.remove(excludeElement);
		int index = randomGenerator.nextInt(copy.size());
		return copy.get(index);
	}

}
