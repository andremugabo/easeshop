package com.ma.codinglab.shopease.core.warehouse.service;

import com.ma.codinglab.shopease.core.warehouse.model.Warehouse;
import com.ma.codinglab.shopease.core.warehouse.repository.IWarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements  IWarehouseService{

    private final IWarehouseRepository warehouseRepository;


    @Override
    public Warehouse registerWarehouse(Warehouse theWarehouse) {
     Optional<Warehouse> foundWarehouse =   warehouseRepository.findByName(theWarehouse.getName());
     if(foundWarehouse.isPresent()){
         throw new IllegalArgumentException("Warehouse already Exists");
     }
        long warehouseNumber  = warehouseRepository.count();
        String regNumber;

        if(warehouseNumber < 10){
            regNumber = "W-00"+warehouseNumber;
        }else if (warehouseNumber < 100){
            regNumber = "W-0"+warehouseNumber;
        } else {
            regNumber = "W-"+warehouseNumber;
        }

        theWarehouse.setRegNumber(regNumber);

        return  warehouseRepository.save(theWarehouse);
    }

    @Override
    public Warehouse updateWarehouse(Warehouse theWarehouse) {
        return null;
    }

    @Override
    public Warehouse deleteWarehouse(Warehouse theWarehouse) {
        return null;
    }

    @Override
    public List<Warehouse> findAllWarehouse() {
        return warehouseRepository.findAll();
    }

    @Override
    public List<Warehouse> findActiveWarehouse(Boolean active) {
        return warehouseRepository.findByActive(Boolean.TRUE);
    }
}
