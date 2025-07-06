package com.ma.codinglab.shopease.core.productCategory.repository;

import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
    ProductCategory findByProductCategory(String productCategory);
    List<ProductCategory> findByProductTypeId(UUID productTYpeId);
}
