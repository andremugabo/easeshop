package com.ma.codinglab.shopease.core.product.service;

import com.ma.codinglab.shopease.core.product.dto.ProductDto;
import com.ma.codinglab.shopease.core.product.models.Product;
import com.ma.codinglab.shopease.core.product.repository.IProductRepository;
import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;
import com.ma.codinglab.shopease.core.productCategory.repository.IProductCategoryRepository;
import com.ma.codinglab.shopease.core.util.product.ImageUploadUtil;
import com.ma.codinglab.shopease.core.warehouse.model.Warehouse;
import com.ma.codinglab.shopease.core.warehouse.repository.IWarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{

    private final IProductRepository productRepository;
    private final IWarehouseRepository warehouseRepository;
    private final IProductCategoryRepository productCategoryRepository;


    @Override
    public Product registerProduct(ProductDto theProductDto) {

        String imagePath = ImageUploadUtil.uploadImage(theProductDto.getImage(), "uploadProduct");

        Product product = new Product();
        product.setName(theProductDto.getName());
        product.setDetails(theProductDto.getDetails());
        product.setPrice(theProductDto.getPrice());
        product.setQuantity(theProductDto.getQuantity());
        product.setFeature(theProductDto.getFeature());
        product.setSpecifications(theProductDto.getSpecifications());
        product.setManufacturedDate(theProductDto.getManufacturedDate());
        product.setExpirationDate(theProductDto.getExpirationDate());

        if(imagePath != null){
            product.setImage(imagePath);
        }

        if(theProductDto.getWarehouseId() != null){
            Warehouse warehouse = warehouseRepository.findById(UUID.fromString(theProductDto.getWarehouseId()))
                    .orElseThrow(()-> new RuntimeException("Warehouse not found"));
            product.setWarehouse(warehouse);
        }

        if (theProductDto.getProductCategoryIds() != null && !theProductDto.getProductCategoryIds().isEmpty()) {
            ProductCategory category = productCategoryRepository.findById(
                    UUID.fromString(theProductDto.getProductCategoryIds().get(0))
            ).orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product theProduct) {
        return null;
    }

    @Override
    public Product deleteProduct(Product theProduct) {
        return null;
    }

    @Override
    public List<Product> findByActive(Boolean active) {
        return productRepository.findByActive(Boolean.TRUE);
    }
}
