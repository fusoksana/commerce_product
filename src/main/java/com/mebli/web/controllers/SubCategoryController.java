package com.mebli.web.controllers;

import com.mebli.domain.SubCategory;
import com.mebli.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubCategoryController {
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    public SubCategoryController(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository=subCategoryRepository;
    }
    @RequestMapping("/subcategories")
    public List<SubCategory> getSubCatAll() {
        return subCategoryRepository.findAll();
    }
}
