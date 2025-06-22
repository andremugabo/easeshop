package com.ma.codinglab.shopease.core.products.model;

import java.time.LocalDate;
import java.util.UUID;

public class Product {
    private UUID id;
    private String productName;
    private String description;
    private Double price;
    private LocalDate manufacturedDate;
    private LocalDate expirationDate;

}
