package com.example.DentalClinic.service;

import ch.qos.logback.core.net.ObjectWriter;
import com.example.DentalClinic.model.Address;
import com.example.DentalClinic.model.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PatientIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void savePatientTest() throws Exception {
        Patient payloadPatient = new Patient("Ríos", "Santiago", "25.664.202", "santirios@gmail.com", new Date(), new Address());
        Patient responsePatient = new Patient("Ríos", "Santiago", "25.664.202", "santirios@gmail.com", new Date(), new Address());

        ObjectWriter writer = (ObjectWriter) new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJSON = ((com.fasterxml.jackson.databind.ObjectWriter) writer).writeValueAsString(payloadPatient);
        String responseJSON = ((com.fasterxml.jackson.databind.ObjectWriter) writer).writeValueAsString(responsePatient);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJSON, response.getResponse().getContentAsString());

    }
}
