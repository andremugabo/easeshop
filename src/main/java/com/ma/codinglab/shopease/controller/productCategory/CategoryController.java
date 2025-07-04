package com.ma.codinglab.shopease.controller.productCategory;

import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;
import com.ma.codinglab.shopease.core.productCategory.service.IProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productCategory")
public class CategoryController {

    private final IProductCategoryService productCategoryService;

    @GetMapping("/productCategoryPage")
    public String getCategory(Model model){
        List<ProductCategory> theProducts = productCategoryService.getAllCategory();
        model.addAttribute("theProductCategory",theProducts);
        model.addAttribute("theCategory", new ProductCategory());
        return "admin/productCategory";
    }







}
