package com.flightplanning.flight.controller.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class FlightControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeAll
	public void setUp() throws Exception {
		// First created data.
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"fc2e0d68-1352-4dc9-8224-b585cf3a257b\",\r\n"
                		+ "    \"aircraftId\": \"1d80f295-3a61-4e69-8b85-ec2d796d29da\",\r\n"
                		+ "    \"airportDestinationId\": \"3dbc4cdd-2c24-4930-bc65-4d2001943d9f\",\r\n"
                		+ "    \"airportSourceId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\r\n"
                		+ "    \"flightDate\": \"20-06-2022\",\r\n"
                		+ "    \"flightTime\": \"10:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isOk()
                );
		
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"fc2e0d68-1352-4dc9-8224-b585cf3a257b\",\r\n"
                		+ "    \"aircraftId\": \"8c9bc002-b72b-4d0c-8bad-26816d5958cc\",\r\n"
                		+ "    \"airportDestinationId\": \"3dbc4cdd-2c24-4930-bc65-4d2001943d9f\",\r\n"
                		+ "    \"airportSourceId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\r\n"
                		+ "    \"flightDate\": \"20-06-2022\",\r\n"
                		+ "    \"flightTime\": \"12:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isOk()
                );
		
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"fc2e0d68-1352-4dc9-8224-b585cf3a257b\",\r\n"
                		+ "    \"aircraftId\": \"b1b7945f-035e-4b35-b391-d9ebefa16a52\",\r\n"
                		+ "    \"airportDestinationId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\r\n"
                		+ "    \"airportSourceId\": \"3dbc4cdd-2c24-4930-bc65-4d2001943d9f\",\r\n"
                		+ "    \"flightDate\": \"20-06-2022\",\r\n"
                		+ "    \"flightTime\": \"14:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isOk()
                );
	}

	@Test
	public void testCreateFlight_ReturnSuccess() throws Exception {
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"f8a3e28c-5f3a-48bb-8332-0ef3e4a551d8\",\r\n"
                		+ "    \"aircraftId\": \"2f52e761-28f1-4395-855f-bff82f822a4b\",\r\n"
                		+ "    \"airportDestinationId\": \"9a3c8e42-cdb9-4ed5-9164-1938cac71920\",\r\n"
                		+ "    \"airportSourceId\": \"10fca35c-b1de-4a53-a9de-59c3e67b1d51\",\r\n"
                		+ "    \"flightDate\": \"18-06-2022\",\r\n"
                		+ "    \"flightTime\": \"10:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isOk()
                );
	}
	
	@Test
	public void testCreateFlight_Return400_AirportSelectionInvalid() throws Exception {
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"f8a3e28c-5f3a-48bb-8332-0ef3e4a551d8\",\r\n"
                		+ "    \"aircraftId\": \"289a5e67-8353-40d7-ad39-201cc85f3710\",\r\n"
                		+ "    \"airportDestinationId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\r\n"
                		+ "    \"airportSourceId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\r\n"
                		+ "    \"flightDate\": \"18-06-2022\",\r\n"
                		+ "    \"flightTime\": \"10:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isBadRequest()
                );
	}
	
	@Test
	public void testCreateFlight_Return400_AircraftAirlineDismatch() throws Exception {
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"fc2e0d68-1352-4dc9-8224-b585cf3a257b\",\r\n"
                		+ "    \"aircraftId\": \"289a5e67-8353-40d7-ad39-201cc85f3710\",\r\n"
                		+ "    \"airportDestinationId\": \"9a3c8e42-cdb9-4ed5-9164-1938cac71920\",\r\n"
                		+ "    \"airportSourceId\": \"c029953d-dc3a-4e72-b685-aab4211a9ab0\",\r\n"
                		+ "    \"flightDate\": \"18-06-2022\",\r\n"
                		+ "    \"flightTime\": \"10:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isBadRequest()
                );
	}
	
	@Test
	public void testCreateFlight_Return400_AircraftAlreadyPlanned() throws Exception {
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"fc2e0d68-1352-4dc9-8224-b585cf3a257b\",\r\n"
                		+ "    \"aircraftId\": \"1d80f295-3a61-4e69-8b85-ec2d796d29da\",\r\n"
                		+ "    \"airportDestinationId\": \"3dbc4cdd-2c24-4930-bc65-4d2001943d9f\",\r\n"
                		+ "    \"airportSourceId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\r\n"
                		+ "    \"flightDate\": \"20-06-2022\",\r\n"
                		+ "    \"flightTime\": \"10:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isBadRequest()
                );
	}
	
	@Test
	public void testCreateFlight_Return400_PlannedFlightInvalid() throws Exception {
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\r\n"
                		+ "    \"airlineId\": \"fc2e0d68-1352-4dc9-8224-b585cf3a257b\",\r\n"
                		+ "    \"aircraftId\": \"7488ea3a-0652-48ed-b98d-439ba4bc6505\",\r\n"
                		+ "    \"airportDestinationId\": \"3dbc4cdd-2c24-4930-bc65-4d2001943d9f\",\r\n"
                		+ "    \"airportSourceId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\r\n"
                		+ "    \"flightDate\": \"20-06-2022\",\r\n"
                		+ "    \"flightTime\": \"10:00:00\",\r\n"
                		+ "    \"flightDuration\": 1\r\n"
                		+ "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isBadRequest()
                );
	}

}
