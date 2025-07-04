package com.ma.codinglab.shopease.core.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private String id;
    private String name;
    private String details;
    private double price;
    private MultipartFile image;
    private String feature;
    private String specifications;
    private Integer quantity;
    private LocalDate manufacturedDate;
    private LocalDate expirationDate;

    private String warehouseId;

    private List<String> orderIds;
    private List<String> reviewIds;
    private List<String> productCategoryIds;
}
