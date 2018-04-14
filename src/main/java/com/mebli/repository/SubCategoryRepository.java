package com.mebli.repository;

import com.mebli.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
    SubCategory findBySubCategoryId( int subCategoryId);
}
