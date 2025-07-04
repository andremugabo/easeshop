package com.ma.codinglab.shopease.core.productCategory.service;

import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;
import com.ma.codinglab.shopease.core.productCategory.repository.IProductCategoryRepository;
import com.ma.codinglab.shopease.core.productType.model.ProductType;
import com.ma.codinglab.shopease.core.productType.repository.IProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImp implements IProductCategoryService {

    private final IProductCategoryRepository categoryRepository;
    private final IProductTypeRepository productTypeRepository;


    @Override
    public ProductCategory registerCategory(ProductCategory theProductCategory) {
        ProductCategory foundCategory = categoryRepository.findByProductCategory(theProductCategory.getProductCategory());
        if(Objects.nonNull(foundCategory)){
            throw new IllegalArgumentException();
        }
        UUID productTypeId = theProductCategory.getProductType().getId();
        ProductType theProductType = productTypeRepository.findById(productTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Product TYpe UUId"));

        theProductCategory.setProductType(theProductType);

        return categoryRepository.save(theProductCategory);
    }

    @Override
    public ProductCategory updateCategory(ProductCategory theProductCategory) {
        return null;
    }

    @Override
    public ProductCategory deleteCategory(ProductCategory thProductCategory) {
        return null;
    }

    @Override
    public List<ProductCategory> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> getCategoryByType(UUID type_id) {
        return categoryRepository.findByProductTypeId(type_id);

    }
}
