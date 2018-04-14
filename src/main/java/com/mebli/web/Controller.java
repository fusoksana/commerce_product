package com.mebli.web;


import com.mebli.domain.Category;
import com.mebli.domain.SubCategory;
import com.mebli.domain.Furniture;
import com.mebli.repository.CategoryRepository;
import com.mebli.repository.FurnitureRepository;
import com.mebli.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/furniture")
public class Controller {

    private final FurnitureRepository furnitureRepository;

    private final CategoryRepository categoryRepository;

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public Controller(FurnitureRepository furnitureRepository,CategoryRepository categoryRepository,SubCategoryRepository subCategoryRepository) {
        this.furnitureRepository = furnitureRepository;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @RequestMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @RequestMapping("/all")
    public List<Furniture> getAllItems() {
        return furnitureRepository.findAll();
    }

    @RequestMapping("/subcat")
    public List<SubCategory> getSubCatAll() {
        return subCategoryRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Furniture> findItemById(@PathVariable("id")Integer id){
        return furnitureRepository.findById(id);
    }

    @RequestMapping("/cat/{categoryID}")
    public List<Furniture> findAllByCategory(@PathVariable("categoryID")Integer categoryID){
        Category category=categoryRepository.findByCategoryID(categoryID);
        return furnitureRepository.findByCategory(category);
    }
    @RequestMapping("/subCat/{subCatId}")
    public List<Furniture> findAllBySubCategoryId(@PathVariable("subCatId")Integer subCategoryId){
       SubCategory subcategory=subCategoryRepository.findBySubCategoryId(subCategoryId);
        return furnitureRepository.findBySubCategory(subcategory);
    }

}
