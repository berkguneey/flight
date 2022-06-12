package com.flightplanning.flight.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Aircraft {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@NotNull
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;

	@NotNull
	@Column(nullable = false, unique = true)
	private String licensePlate;

	@ManyToOne
	@JoinColumn(name = "aircraftModelId")
	private AircraftModel aircraftModel;

	@ManyToOne
	@JoinColumn(name = "airlineId")
	private Airline airline;
	
	@OneToMany(mappedBy = "aircraft", targetEntity = Flight.class, cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();

}
