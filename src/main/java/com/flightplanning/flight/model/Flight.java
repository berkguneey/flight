package com.flightplanning.flight.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Flight {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@NotNull
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String code;
	
	@ManyToOne()
	@JoinColumn(name = "aircraftId")
	private Aircraft aircraft;
	
	@ManyToOne()
	@JoinColumn(name = "sourceId")
	private Airport source;
	
	@ManyToOne()
	@JoinColumn(name = "destinationId")
	private Airport destination;
	
	@Column(nullable = false)
	private LocalDate flightDate;
	
	@Column(nullable = false)
	private LocalTime flightTime;

}
