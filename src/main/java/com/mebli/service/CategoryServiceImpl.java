package com.mebli.service;

import com.mebli.domain.Category;
import com.mebli.dto.CategoryDto;
import com.mebli.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public List<CategoryDto> retreieveAll() {
        List<Category> categories = categoryRepository.findAll();
        return transferringCategoryListToDtoList(categories);

    }

    @Transactional
    public CategoryDto transferrindCategoryToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryID(category.getCategoryID());
        categoryDto.setSubCategories(category.getSubCategories());
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }

    @Transactional
    public List<CategoryDto> transferringCategoryListToDtoList(List<Category> categoryList) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtos.add(transferrindCategoryToDto(category));
        }
        return categoryDtos;
    }

    @Transactional
    @Override
    public Category retrieveCategoryByID(int categoryId) {
        return categoryRepository.findByCategoryID(categoryId);
    }
}
