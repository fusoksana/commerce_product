package com.mebli;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.mebli.repository.FurnitureRepository;
import com.mebli.repository.SubCategoryRepository;
import com.mebli.web.controllers.FurnitureListingController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    private FurnitureListingController furnitureListingController;
    private FurnitureRepository furnitureRepository;
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public ApplicationTest(FurnitureListingController furnitureListingController, FurnitureRepository furnitureRepository, SubCategoryRepository subCategoryRepository){
        this.furnitureListingController = furnitureListingController;
        this.furnitureRepository=furnitureRepository;
        this.subCategoryRepository=subCategoryRepository;
    }
    @Test
    public void contextTest() {
        assertThat(furnitureListingController).isNotNull();
        assertThat(furnitureRepository).isNotNull();
        assertThat(subCategoryRepository).isNotNull();
    }

}
