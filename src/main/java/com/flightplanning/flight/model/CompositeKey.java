package com.flightplanning.flight.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CompositeKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "license_plate")
	private String licensePlate;
	
	@Column(name = "airline_id")
	private UUID airlineId;

	@Column(name = "aircraft_id")
	private UUID aircraftId;

}
