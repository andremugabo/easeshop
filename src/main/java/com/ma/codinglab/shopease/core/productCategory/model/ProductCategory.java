package com.ma.codinglab.shopease.core.productCategory.model;

import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.product.models.Product;
import com.ma.codinglab.shopease.core.productType.model.ProductType;
import com.ma.codinglab.shopease.core.util.product.EProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "productcategory")
public class ProductCategory extends AbstractBaseEntity {
    @Column(nullable = false, unique = true)
    private String productCategory;
    @Column(length = 1000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "ProductType_id")
    private ProductType productType;
    @OneToMany(mappedBy = "category")
    private List<Product> product;
}
