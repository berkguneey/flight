package com.flightplanning.flight.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airline {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@NotNull
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;

	@NotNull
	@Column(nullable = false)
	private String iataCode;
	
	@NotNull
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "airline", targetEntity = Aircraft.class, cascade = CascadeType.ALL)
	private List<Aircraft> aircrafts = new ArrayList<>();
	
	@OneToMany(mappedBy = "airline", targetEntity = Flight.class, cascade = CascadeType.ALL)
	private List<Flight> flights = new ArrayList<>();

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

}
