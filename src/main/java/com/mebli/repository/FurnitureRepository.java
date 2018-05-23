package com.mebli.repository;

import com.mebli.domain.Category;
import com.mebli.domain.Furniture;
import com.mebli.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
    List<Furniture> findByCategory(Category category);

    List<Furniture> findBySubCategory(SubCategory subCategory);

    Furniture findByItemId(int Id);
}
