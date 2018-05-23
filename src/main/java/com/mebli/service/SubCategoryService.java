package com.mebli.service;

import com.mebli.domain.SubCategory;
import com.mebli.dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {

    List<SubCategoryDto> retrieveAll();

    SubCategory retrieveBySubCategoryId(int subCategoryId);


}
