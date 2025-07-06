package com.ma.codinglab.shopease.core.product.repository;

import com.ma.codinglab.shopease.core.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByActive(Boolean active);
}
