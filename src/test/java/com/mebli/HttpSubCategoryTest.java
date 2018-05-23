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
public class HttpSubCategoryTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public static final String HOST = "http://localhost:";

    private void assertThatStatusIsOKAndBodyIsFilled(ResponseEntity<String> response) {
        assertTrue((response.getStatusCode().equals(HttpStatus.OK)) && (response.getBody().length() >= 5));
    }

    @Test
    public void checkResponceGetSubCatAllTest() {
        ResponseEntity<String> response = this.restTemplate.getForEntity(HOST + port + "/subcategories", String.class);
        assertThatStatusIsOKAndBodyIsFilled(response);
    }
}
