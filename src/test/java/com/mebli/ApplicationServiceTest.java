package com.mebli;

import com.mebli.service.FurnitureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServiceTest {
    @Autowired
    private FurnitureService furnitureService;

    @Test
    public void contextTest() {
        assertThat(furnitureService).isNotNull();
    }
}
