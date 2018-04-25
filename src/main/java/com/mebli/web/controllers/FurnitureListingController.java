package com.mebli.web.controllers;
import com.mebli.domain.Category;
import com.mebli.domain.Furniture;
import com.mebli.domain.SubCategory;
import com.mebli.repository.CategoryRepository;
import com.mebli.repository.FurnitureRepository;
import com.mebli.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FurnitureListingController {
    private final FurnitureRepository furnitureRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    @Autowired
    public FurnitureListingController(FurnitureRepository furnitureRepository, CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.furnitureRepository = furnitureRepository;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }
    @RequestMapping("/furnitures")
    public List<Furniture> getAllItems() {
        return furnitureRepository.findAll();
    }
    @RequestMapping("/furnitures/categories/{categoryID}")
    public List<Furniture> findAllByCategory(@PathVariable("categoryID")Integer categoryID){
        Category category=categoryRepository.findByCategoryID(categoryID);
        return furnitureRepository.findByCategory(category);
    }
    @RequestMapping("/furnitures/subcategories/{subCatId}")
    public List<Furniture> findAllBySubCategoryId(@PathVariable("subCatId")Integer subCategoryId){
       SubCategory subcategory=subCategoryRepository.findBySubCategoryId(subCategoryId);
        return furnitureRepository.findBySubCategory(subcategory);
    }
}
