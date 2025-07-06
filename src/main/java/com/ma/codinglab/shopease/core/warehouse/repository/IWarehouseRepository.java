package com.ma.codinglab.shopease.core.warehouse.repository;

import com.ma.codinglab.shopease.core.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface IWarehouseRepository extends JpaRepository<Warehouse, UUID> {
    Optional<Warehouse> findByName(String name);
    List<Warehouse> findByActive(Boolean active);
}
