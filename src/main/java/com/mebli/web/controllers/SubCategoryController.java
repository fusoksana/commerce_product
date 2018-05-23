package com.mebli.web.controllers;

import com.mebli.dto.SubCategoryDto;
import com.mebli.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubCategoryController {
    private SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @RequestMapping(path = "/subcategories", method = RequestMethod.GET)
    public List<SubCategoryDto> getSubCatAll() {
        return subCategoryService.retrieveAll();
    }
}
