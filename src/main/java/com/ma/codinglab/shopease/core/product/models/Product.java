package com.ma.codinglab.shopease.core.product.models;


import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.order.model.Order;
import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;
import com.ma.codinglab.shopease.core.review.model.Review;
import com.ma.codinglab.shopease.core.warehouse.model.Warehouse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "product")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product extends AbstractBaseEntity {
    @Column(name = "product_name", nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String details;
    private double price;
    private String image;
    private String feature;
    private String specifications;
    private Integer quantity;
    private LocalDate manufacturedDate;
    private LocalDate expirationDate;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
    @OneToMany(mappedBy = "product")
    private List<Order> orders;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;



}
