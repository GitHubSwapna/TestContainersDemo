package com.example.DemoTestContainers.controller;

import com.example.DemoTestContainers.dto.BookResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
@ActiveProfiles("doc")
public class TestBookControllerMockMvc
{
    @Autowired
    MockMvc mockMvc;

    @Container
    @ServiceConnection
    public static MySQLContainer mySQLContainer =
            new MySQLContainer("mysql:8.1.0");


    @Test
    public void findAllBooks() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/all")

        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void findBook() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/books/{title}","moneymgmt")

                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
