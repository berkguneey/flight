package com.flightplanning.flight.util;

import java.time.LocalTime;
import java.util.Random;

public class LocalTimeGenerator {

	public static LocalTime generate() {
		final Random randomGenerator = new Random();
		LocalTime localTime = LocalTime.of(randomGenerator.nextInt(24), randomGenerator.nextInt(4) * 15, 0);
		return localTime;
	}

}
