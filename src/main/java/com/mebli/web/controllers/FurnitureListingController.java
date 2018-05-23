package com.mebli.web.controllers;

import com.mebli.dto.FurnitureDTO;
import com.mebli.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FurnitureListingController {

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureListingController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @RequestMapping(path = "/furnitures", method = RequestMethod.GET)
    public List<FurnitureDTO> getAllItems() {
        return furnitureService.retrieveAll();
    }

    @RequestMapping(path = "/furnitures/categories/{categoryID}", method = RequestMethod.GET)
    public List<FurnitureDTO> findAllByCategoryId(@PathVariable("categoryID") Integer categoryID) {
        return furnitureService.retrieveByCategory(categoryID);
    }

    @RequestMapping(path = "/furnitures/subcategories/{subCatId}", method = RequestMethod.GET)
    public List<FurnitureDTO> findAllBySubCategoryId(@PathVariable("subCatId") Integer subCategoryId) {
        return furnitureService.retrieveBySubCategory(subCategoryId);
    }


}
