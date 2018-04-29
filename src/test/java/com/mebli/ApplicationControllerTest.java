package com.mebli;

import com.mebli.web.controllers.CategoryController;
import com.mebli.web.controllers.FurnitureController;
import com.mebli.web.controllers.FurnitureListingController;
import com.mebli.web.controllers.SubCategoryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationControllerTest {
    @Autowired
    private CategoryController categoryController;
    @Autowired
    private SubCategoryController subCategoryController;
    @Autowired
    private FurnitureListingController furnitureListingController;
    @Autowired
    private FurnitureController furnitureController;

    @Test
    public void contextTest() {
        assertThat(furnitureListingController).isNotNull();
        assertThat(furnitureController).isNotNull();
        assertThat(categoryController).isNotNull();
        assertThat(subCategoryController).isNotNull();
    }
}
