package com.mebli.web.controllers;

import com.mebli.domain.Category;
import com.mebli.domain.SubCategory;
import com.mebli.dto.FurnitureDTO;
import com.mebli.service.CategoryService;
import com.mebli.service.FurnitureService;
import com.mebli.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FurnitureListingController {
    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureListingController(CategoryService categoryService, SubCategoryService subCategoryService, FurnitureService furnitureService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.furnitureService = furnitureService;
    }

    @RequestMapping(path = "/furnitures", method = RequestMethod.GET)
    public List<FurnitureDTO> getAllItems() {
        return furnitureService.retrieveAll();
    }

    @RequestMapping(path = "/furnitures/categories/{categoryID}", method = RequestMethod.GET)
    public List<FurnitureDTO> findAllByCategoryId(@PathVariable("categoryID") Integer categoryID) {
        Category category = categoryService.retrieveCategoryByID(categoryID);
        return furnitureService.retrieveByCategory(category);
    }

    @RequestMapping(path = "/furnitures/subcategories/{subCatId}", method = RequestMethod.GET)
    public List<FurnitureDTO> findAllBySubCategoryId(@PathVariable("subCatId") Integer subCategoryId) {
        SubCategory subcategory = subCategoryService.retrieveBySubCategoryId(subCategoryId);
        return furnitureService.retrieveBySubCategory(subcategory);
    }


}
