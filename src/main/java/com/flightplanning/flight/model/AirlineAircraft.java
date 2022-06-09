package com.flightplanning.flight.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Data
@Entity
public class AirlineAircraft {
	
	@EmbeddedId
	CompositeKey key;

	@ManyToOne
	@MapsId("airlineId")
	private Airline airline;

	@ManyToOne
	@MapsId("aircraftId")
	private Aircraft aircraft;

}
