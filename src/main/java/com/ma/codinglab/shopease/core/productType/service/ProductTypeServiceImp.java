package com.ma.codinglab.shopease.core.productType.service;

import com.ma.codinglab.shopease.core.productType.dto.ProductTypeDTO;
import com.ma.codinglab.shopease.core.productType.model.ProductType;
import com.ma.codinglab.shopease.core.productType.repository.IProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductTypeServiceImp implements IProductTypeService{

    private final IProductTypeRepository productTypeRepository;

    @Override
    public ProductType createProductType(ProductTypeDTO theProductTypeDto) {
        List<ProductType> existingTypes = productTypeRepository.findByProductType(theProductTypeDto.getProductType());

        for (ProductType existingType : existingTypes) {
            if (existingType.isActive()) {
                throw new IllegalArgumentException("ProductType already exists and is active: " + theProductTypeDto.getProductType());
            }
        }

        ProductType newProductType = new ProductType();
        newProductType.setProductType(theProductTypeDto.getProductType().toUpperCase());
        newProductType.setDescription(theProductTypeDto.getDescription());

        return productTypeRepository.save(newProductType);
    }

    @Override
    public ProductType updateProductType(ProductTypeDTO theProductTypeDto) {
        return null;
    }

    @Override
    public ProductType deleteProductType(ProductTypeDTO theProductTypeDto) {
        return null;
    }


    @Override
    public List<ProductType> findProductTypeByActive(Boolean active) {
        return productTypeRepository.findByActive(Boolean.TRUE);
    }
}
