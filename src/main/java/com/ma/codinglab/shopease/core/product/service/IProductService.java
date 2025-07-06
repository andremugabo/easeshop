package com.ma.codinglab.shopease.core.product.service;

import com.ma.codinglab.shopease.core.product.dto.ProductDto;
import com.ma.codinglab.shopease.core.product.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product registerProduct(ProductDto theProductDto);
    Product updateProduct(Product theProduct);
    Product deleteProduct(Product theProduct);
    List<Product> findByActive(Boolean active);
}
