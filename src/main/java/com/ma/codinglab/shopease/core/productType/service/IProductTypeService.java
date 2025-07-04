package com.ma.codinglab.shopease.core.productType.service;

import com.ma.codinglab.shopease.core.productType.dto.ProductTypeDTO;
import com.ma.codinglab.shopease.core.productType.model.ProductType;

import java.util.List;
import java.util.Optional;

public interface IProductTypeService {
    ProductType createProductType(ProductTypeDTO theProductTypeDto);
    ProductType updateProductType(ProductTypeDTO theProductTypeDto);
    ProductType deleteProductType(ProductTypeDTO theProductTypeDto);
    List<ProductType> findProductTypeByActive(Boolean active);

}
