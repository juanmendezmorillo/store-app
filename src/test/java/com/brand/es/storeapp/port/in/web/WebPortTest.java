package com.brand.es.storeapp.port.in.web;

import com.brand.es.storeapp.StoreAppApplication;
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
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by JMENDEZ on 13/12/2022.
 */
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = StoreAppApplication.class)
@ActiveProfiles("test")
@DisplayName("WebPort REST API Tests")
@Tag("IntegrationTest")
public class WebPortTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("when GET ProductIds, then returns 200")
    public void whenGetProductIds_thenReturns200() {

        //when
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/api/productstock", String.class);

        //then
        assertEquals(OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isEmpty());
    }

}
