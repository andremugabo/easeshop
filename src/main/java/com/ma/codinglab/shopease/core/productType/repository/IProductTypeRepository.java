package com.ma.codinglab.shopease.core.productType.repository;

import com.ma.codinglab.shopease.core.productType.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductTypeRepository extends JpaRepository<ProductType, UUID> {
    List<ProductType> findByProductType(String productType);
    List<ProductType> findByActive(Boolean active);
}
