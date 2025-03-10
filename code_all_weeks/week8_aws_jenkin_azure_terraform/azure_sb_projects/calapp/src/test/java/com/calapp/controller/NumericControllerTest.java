package com.calapp.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NumericControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void smallerThanOrEqualToFiftyMessage() throws Exception {
        MvcResult mvcResult=mockMvc.perform(get("/compare/49"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals("Smaller than or equal to 50", content);

    }

    @Test
    public void greaterThanFiftyMessage() throws Exception {
        MvcResult mvcResult= mockMvc.perform(get("/compare/51"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals("Greater than 50", content);
    }

    @Test
    public void welcomeMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }


}