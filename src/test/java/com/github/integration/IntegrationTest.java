package com.github.integration;

import com.github.dto.rest.SearchResultDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
@DisplayName("Repository Controller REST API Tests")
@Tag("IntegrationTest")
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("When GET Repositories list with valid params, then returns 200")
    public void whenGetRepositoriesList_validParams_thenReturns200() {
        //when
        ResponseEntity<SearchResultDTO> responseEntity = restTemplate.getForEntity("/api/search/repositories?from=2020-01-01&lang=java", SearchResultDTO.class);

        //then
        assertEquals(OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().getItems().isEmpty());
    }

    @Test
    @DisplayName("When GET Repositories list with valid params and limit 10, then returns 200 and 10 items")
    public void whenGetRepositoriesList_validParams_limit10_thenReturns200() {
        //when
        ResponseEntity<SearchResultDTO> responseEntity = restTemplate.getForEntity("/api/search/repositories?from=2020-01-01&lang=java&limit=10", SearchResultDTO.class);

        //then
        assertEquals(OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().getItems().isEmpty());
        assertEquals(10, responseEntity.getBody().getItems().size());
    }

    @Test
    @DisplayName("When GET Repositories list with invalid language, then returns 400")
    public void whenGetRepositoriesList_invalidLanguage_thenReturns400() {
        //when
        ResponseEntity<SearchResultDTO> responseEntity = restTemplate.getForEntity("/api/search/repositories?lang=javaX", SearchResultDTO.class);

        //then
        assertEquals(BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertNull(responseEntity.getBody().getItems());
    }

    @Test
    @DisplayName("When GET Repositories list with invalid date, then returns 400")
    public void whenGetRepositoriesList_invalidDate_thenReturns400() {
        //when
        ResponseEntity<SearchResultDTO> responseEntity = restTemplate.getForEntity("/api/search/repositories?from=X", SearchResultDTO.class);

        //then
        assertEquals(BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertNull(responseEntity.getBody().getItems());
    }
}
