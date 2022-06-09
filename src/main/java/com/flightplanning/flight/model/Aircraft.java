package com.flightplanning.flight.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Aircraft {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@NotNull
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	
	@NotNull
	@Column(nullable = false)
	private String icaoCode;
	
	@NotNull
	@Column(nullable = false)
	private String iataCode;
	
	@NotNull
	@Column(nullable = false)
	private String model;
	
	@OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL)
	private Set<AirlineAircraft> airlines = new HashSet<>();
	
	@OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL)
    private Set<Flight> flights = new HashSet<>();

}
