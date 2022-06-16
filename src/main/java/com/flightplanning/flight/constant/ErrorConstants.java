package com.flightplanning.flight.constant;

public enum ErrorConstants {
	
	AIRLINE_NOT_FOUND(1001L, "Airline not found."),
	AIRPORT_NOT_FOUND(1002L, "Airport not found."),
	AIRCRAFT_NOT_FOUND(1003L, "Aircraft not found."),
	AIRCRAFT_AIRLINE_DISMATCH(1014L, "The aircraft is not owned by the airline."),
	FLIGHT_INVALID(1015L, "There must be daily at most 3 flights for an airline between 2 destinations.");
	
	private Long code;
	private String message;
	
	private ErrorConstants(Long code, String message) {
		this.code = code;
		this.message = message;
	}

	public Long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
