package com.mebli.web.controllers;

import com.mebli.domain.Category;
import com.mebli.domain.Furniture;
import com.mebli.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryRepository  categoryRepository;
    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }
    @RequestMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
