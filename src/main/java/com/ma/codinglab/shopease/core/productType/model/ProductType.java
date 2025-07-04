package com.ma.codinglab.shopease.core.productType.model;

import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;
import com.ma.codinglab.shopease.core.util.product.EProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "producttype")
public class ProductType extends AbstractBaseEntity {
    @Column(nullable = false)
    private String productType;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "id")
    private List<ProductCategory> productCategory;
}
