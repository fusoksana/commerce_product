package com.mebli;

import com.mebli.repository.CategoryRepository;
import com.mebli.repository.FurnitureRepository;
import com.mebli.repository.SubCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationRepositoryTest {
    @Autowired
    private FurnitureRepository furnitureRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Test
    public void contexTest() {
        assertThat(furnitureRepository).isNotNull();
        assertThat(categoryRepository).isNotNull();
        assertThat(subCategoryRepository).isNotNull();
    }
}
