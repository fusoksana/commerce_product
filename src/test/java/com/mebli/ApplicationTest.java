package com.mebli;

import com.mebli.repository.FurnitureRepository;
import com.mebli.repository.SubCategoryRepository;
import com.mebli.web.Controller;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private Controller controller;

    @Autowired
    private FurnitureRepository furnitureRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(furnitureRepository).isNotNull();
        assertThat(subCategoryRepository).isNotNull();
    }




}
