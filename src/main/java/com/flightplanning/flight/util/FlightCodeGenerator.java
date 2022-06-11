package com.flightplanning.flight.util;

import java.util.Random;

public class FlightCodeGenerator {

	public static String generate(String iataCode) {
		final Random randomGenerator = new Random();
		return iataCode + "-" + randomGenerator.nextInt(9999);
	}

}
