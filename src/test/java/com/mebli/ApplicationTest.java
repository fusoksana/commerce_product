package com.mebli;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mebli.repository.FurnitureRepository;
import com.mebli.repository.SubCategoryRepository;
import com.mebli.web.Controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    private Controller controller;
    private FurnitureRepository furnitureRepository;
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public ApplicationTest(Controller controller,FurnitureRepository furnitureRepository,SubCategoryRepository subCategoryRepository){
        this.controller=controller;
        this.furnitureRepository=furnitureRepository;
        this.subCategoryRepository=subCategoryRepository;
    }
    @Test
    public void contextTest() {
        assertThat(controller).isNotNull();
        assertThat(furnitureRepository).isNotNull();
        assertThat(subCategoryRepository).isNotNull();
    }

}
