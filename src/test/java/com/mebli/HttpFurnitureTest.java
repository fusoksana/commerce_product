package com.mebli;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpFurnitureTest {

    @LocalServerPort
    private int port;

    public static final String HOST = "http://localhost:";

    @Autowired
    private TestRestTemplate restTemplate;

    public void assertThatStatusIsOKAndBodyIsFilled(ResponseEntity<String> response) {
        assertTrue((response.getStatusCode().equals(HttpStatus.OK)) && (response.getBody().length() >= 5));
    }

    @Test
    public void checkResponceFindItemByIdTest() {
        ResponseEntity<String> response = this.restTemplate.getForEntity(HOST + port + "/furnitures/34", String.class);
        assertThatStatusIsOKAndBodyIsFilled(response);
    }
}
