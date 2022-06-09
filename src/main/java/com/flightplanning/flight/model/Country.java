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
public class Country {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@NotNull
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	
	@NotNull
	@Column(nullable = false)
	private String name;
	
	@NotNull
	@Column(nullable = false)
	private String iso2;
	
	@NotNull
	@Column(nullable = false)
	private String iso3;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Airport> airports = new HashSet<>();

}
