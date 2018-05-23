package com.mebli.service;

import com.mebli.domain.Category;
import com.mebli.domain.Furniture;
import com.mebli.domain.SubCategory;
import com.mebli.dto.FurnitureDTO;

import java.util.List;

public interface FurnitureService {

    void saveElement(Furniture element);

    List<FurnitureDTO> retrieveAll();

    FurnitureDTO retrieveById(Integer id);

    List<FurnitureDTO> retrieveBySubCategory(int subcategoryId);

    List<FurnitureDTO> retrieveByCategory(int categoryID);

}
