package com.mebli.service;

import com.mebli.domain.Category;
import com.mebli.domain.Furniture;
import com.mebli.domain.SubCategory;
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

    @Autowired
    public FurnitureServiceImpl(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
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
    public List<FurnitureDTO> retrieveByCategory(Category category) {
        List<Furniture> furnitureList = furnitureRepository.findByCategory(category);
        return transferingListToDTOList(furnitureList);

    }

    @Transactional
    @Override
    public List<FurnitureDTO> retrieveBySubCategory(SubCategory subcategory) {
        List<Furniture> furnitureList = furnitureRepository.findBySubCategory(subcategory);
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
