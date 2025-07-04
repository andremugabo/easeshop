package com.ma.codinglab.shopease.core.productType.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeDTO {

    private String id;

    @NotBlank(message = "Product type name is required")
    private String productType;

    @Size(max = 255, message = "Description must be at most 255 characters")
    private String description;

    @NotNull(message = "At least one product category must be selected")
    private List<Long> productCategoryIds;
}
