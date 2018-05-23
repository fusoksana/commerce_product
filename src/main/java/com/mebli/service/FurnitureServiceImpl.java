package com.mebli.service;

import com.mebli.domain.Furniture;
import com.mebli.dto.FurnitureDTO;
import com.mebli.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private FurnitureRepository furnitureRepository;

    private CategoryService categoryService;

    private SubCategoryService subCategoryService;

    @Autowired
    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, CategoryService categoryService, SubCategoryService subCategoryService) {
        this.furnitureRepository = furnitureRepository;
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
    }

    @Transactional
    @Override
    public void saveElement(Furniture element) {
        furnitureRepository.save(element);

    }

    @Transactional
    @Override
    public FurnitureDTO retrieveById(Integer id) {
        Furniture furniture = furnitureRepository.findByItemId(id);
        return transferringFurnitureToDTO(furniture);

    }

    @Transactional
    @Override
    public List<FurnitureDTO> retrieveAll() {
        List<Furniture> furnitureList = furnitureRepository.findAll();
        return transferingListToDTOList(furnitureList);
    }

    @Transactional
    @Override
    public List<FurnitureDTO> retrieveByCategory(int categoryID) {
        List<Furniture> furnitureList = furnitureRepository.findByCategory(categoryService.retrieveCategoryByID(categoryID));
        return transferingListToDTOList(furnitureList);

    }

    @Transactional
    @Override
    public List<FurnitureDTO> retrieveBySubCategory(int subcategoryId) {
        List<Furniture> furnitureList = furnitureRepository.findBySubCategory(subCategoryService.retrieveBySubCategoryId(subcategoryId));
        return transferingListToDTOList(furnitureList);
    }

    @Transactional
    public FurnitureDTO transferringFurnitureToDTO(Furniture furniture) {
        FurnitureDTO dto = new FurnitureDTO();
        dto.setName(furniture.getName());
        dto.setAvailability(furniture.getAvailability());
        dto.setDescription(furniture.getDescription());
        dto.setItemId(furniture.getItemId());
        dto.setManufacturer(furniture.getManufacturer());
        dto.setSize(furniture.getSize());
        dto.setCategoryId(furniture.getCategory().getCategoryID());
        dto.setSubCategoryId(furniture.getSubCategory().getSubCategoryId());
        return dto;
    }

    @Transactional
    public List<FurnitureDTO> transferingListToDTOList(List<Furniture> furnitureList) {
        List<FurnitureDTO> furnitureDTOs = new ArrayList<>();
        for (Furniture furniture : furnitureList) {
            FurnitureDTO dto = transferringFurnitureToDTO(furniture);
            furnitureDTOs.add(dto);
        }
        return furnitureDTOs;
    }
}
