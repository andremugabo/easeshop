package com.ma.codinglab.shopease.controller.product;

import com.ma.codinglab.shopease.core.product.dto.ProductDto;
import com.ma.codinglab.shopease.core.product.models.Product;
import com.ma.codinglab.shopease.core.product.service.IProductService;
import com.ma.codinglab.shopease.core.productCategory.service.IProductCategoryService;
import com.ma.codinglab.shopease.core.warehouse.service.IWarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;
    private final IProductCategoryService productCategoryService;
    private final IWarehouseService warehouseService;

    @GetMapping("/productPage")
    public String getAllProducts(Model model){
        List<Product> theProduct = productService.findByActive(Boolean.TRUE);
        model.addAttribute("getProduct", new ProductDto());
        model.addAttribute("theProducts", theProduct);
        model.addAttribute("categories", productCategoryService.getAllCategory());
        model.addAttribute("warehouses", warehouseService.findActiveWarehouse(Boolean.TRUE));

        return "admin/productPage";

    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("getProduct") ProductDto theProductDto, Model model){
        if(Objects.nonNull(theProductDto)){
            productService.registerProduct(theProductDto);
            model.addAttribute("message", "Product Registered Successfully");
        } else {
            model.addAttribute("error", "Failed to register the product");
        }
        return "admin/productPage";
    }
}
