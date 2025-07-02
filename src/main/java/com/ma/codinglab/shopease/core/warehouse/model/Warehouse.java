package com.ma.codinglab.shopease.core.warehouse.model;


import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.product.models.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "warehouse")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Warehouse extends AbstractBaseEntity {
    @Column(name ="name",nullable = false,unique = true)
    private String name;
    @Column(name = "location",nullable = false)
    private String location;
    @Column(name = "reg_number",nullable = false,unique = true)
    private String regNumber;
    @OneToMany(mappedBy = "warehouse")
    private List<Product> products;
}
