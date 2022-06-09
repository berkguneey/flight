package com.flightplanning.flight.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airport {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@NotNull
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String icaoCode;
	
	@NotNull
	@Column(nullable = false)
	private String iataCode;
	
	@NotNull
	@Column(nullable = false)
	private String name;
	
	@ManyToOne()
	@JoinColumn(name = "countryId")
	private Country country;
	
	@OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    private Set<Flight> sourceFlights = new HashSet<>();
	
	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private Set<Flight> destinationFlights = new HashSet<>();
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

}
