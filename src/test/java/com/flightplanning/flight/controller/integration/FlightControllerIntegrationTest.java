package com.flightplanning.flight.controller.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class FlightControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCreateFlight_ReturnSuccess() throws Exception {
		this.mockMvc.perform(
				post("/api/v0/flights")
                .content("{\"airlineId\": \"fc2e0d68-1352-4dc9-8224-b585cf3a257b\",\"aircraftId\": \"57d81598-2c10-49b1-a812-34e073cf41aa\",\"airportDestinationId\": \"9fdafcfb-4395-416b-9187-fdb7b2e7c0d2\",\"airportSourceId\": \"3dbc4cdd-2c24-4930-bc65-4d2001943d9f\",\"flightDate\": \"17-02-2022\",\"flightTime\": \"10:00:00\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
                .andExpect(status().isOk()
                );
	}

}
