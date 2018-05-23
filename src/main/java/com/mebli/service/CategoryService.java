package com.mebli.service;

import com.mebli.domain.Category;
import com.mebli.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> retreieveAll();

    Category retrieveCategoryByID(int categoryId);
}
