package com.ma.codinglab.shopease.core.warehouse.service;

import com.ma.codinglab.shopease.core.warehouse.model.Warehouse;
import java.util.*;

public interface IWarehouseService {
    Warehouse registerWarehouse(Warehouse theWarehouse);
    Warehouse updateWarehouse(Warehouse theWarehouse);
    Warehouse deleteWarehouse(Warehouse theWarehouse);
    List<Warehouse> findAllWarehouse();
    List<Warehouse> findActiveWarehouse(Boolean active);
}
