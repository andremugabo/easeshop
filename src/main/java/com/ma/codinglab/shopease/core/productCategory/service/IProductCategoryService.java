package com.ma.codinglab.shopease.core.productCategory.service;

import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;

import java.util.List;
import java.util.UUID;

public interface IProductCategoryService {
    ProductCategory registerCategory(ProductCategory theProductCategory);
    ProductCategory updateCategory(ProductCategory theProductCategory);
    ProductCategory deleteCategory(ProductCategory thProductCategory);
    List<ProductCategory> getAllCategory();
    List<ProductCategory> getCategoryByType(UUID type_id);
}
