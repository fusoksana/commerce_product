package com.mebli.service;

import com.mebli.domain.SubCategory;
import com.mebli.dto.SubCategoryDto;
import com.mebli.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Transactional
    @Override

    public List<SubCategoryDto> retrieveAll() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return transerringSubCategoryListToDtoList(subCategories);


    }

    @Transactional
    public SubCategoryDto transerringSubCategoryToDto(SubCategory subCategory) {
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        subCategory.setCategoryId(subCategory.getCategoryId());
        subCategory.setName(subCategory.getName());
        subCategory.setSubCategoryId(subCategory.getSubCategoryId());
        return subCategoryDto;

    }

    @Transactional
    public List<SubCategoryDto> transerringSubCategoryListToDtoList(List<SubCategory> subCategoryList) {
        List<SubCategoryDto> subCategoryDtos = new ArrayList<>();
        for (SubCategory subCategory : subCategoryList) {
            subCategoryDtos.add(transerringSubCategoryToDto(subCategory));
        }
        return subCategoryDtos;
    }

    @Transactional
    @Override
    public SubCategory retrieveBySubCategoryId(int subCategoryId) {
        return subCategoryRepository.findBySubCategoryId(subCategoryId);
    }
}
