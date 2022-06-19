package com.flightplanning.flight.constant;

public enum ErrorConstants {
	
	AIRLINE_NOT_FOUND(1001L, "Airline not found."),
	AIRPORT_NOT_FOUND(1002L, "Airport not found."),
	AIRCRAFT_NOT_FOUND(1003L, "Aircraft not found."),
	AIRCRAFT_AIRLINE_DISMATCH(1014L, "The aircraft is not owned by the airline."),
	AIRCRAFT_ALREADY_PLANNED(1015L, "The aircraft is planned for another flight at this hour."),
	AIRPORT_SELECTION_INVALID(1016L, "Source airport and destination airport can not be the same."),
	PLANNED_FLIGHT_INVALID(1017L, "There must be daily at most 3 flights for an airline between 2 destinations.");
	
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
