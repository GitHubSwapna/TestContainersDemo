package com.example.DemoTestContainers.controller;

import com.example.DemoTestContainers.dto.BookDTO;
import com.example.DemoTestContainers.dto.BookResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
//import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test"})
public class TestBookController
{
    @LocalServerPort
    private int port;

    @Value("${profile.loaded}")
    private String profile;

    private StringBuilder baseUrl = new StringBuilder("http://localhost:");
    private static TestRestTemplate restTemplate;

    //private static RestTemplate restTemplate;

    @BeforeAll
    public static void init(){
        restTemplate = new TestRestTemplate();
    }

    @BeforeEach
    public void setup(){
        baseUrl.append(port+"/books");
    }


    @Test
    public void testAddBooks() {
        baseUrl.append("/create");
        BookDTO dto = new BookDTO();
        dto.setAuthor("testcaseauthor");
        dto.setTitle("testcase");
      BookDTO response = restTemplate.postForObject(baseUrl.toString(), dto, BookDTO.class);
        assertEquals("testcase", response.getTitle());

    }

    @Test
    public void testFindAllBooks() {
        System.out.println("Active Profile: "+profile);
        baseUrl.append("/all");
        BookResponse response = restTemplate.getForObject(baseUrl.toString(), BookResponse.class);
        assertTrue(response.getTotalElements() > 1);
    }


}
