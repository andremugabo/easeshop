package com.ma.codinglab.shopease.controller.productCategory;

import com.ma.codinglab.shopease.core.productCategory.model.ProductCategory;
import com.ma.codinglab.shopease.core.productCategory.service.IProductCategoryService;
import com.ma.codinglab.shopease.core.productType.service.IProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productCategory")
public class CategoryController {

    private final IProductCategoryService productCategoryService;
    private final IProductTypeService productTypeService;

    @GetMapping("/productCategoryPage")
    public String getCategory(Model model){
        List<ProductCategory> theProducts = productCategoryService.getAllCategory();
        model.addAttribute("theProductCategory",theProducts);
        model.addAttribute("theCategory", new ProductCategory());
        model.addAttribute("productTypes", productTypeService.findProductTypeByActive(Boolean.TRUE));
        return "admin/productCategory";
    }


    @PostMapping("/addCategory")
    public String createCategory(@ModelAttribute("createCategory") ProductCategory theCategory, Model model){
        if(Objects.nonNull(theCategory)){
            productCategoryService.registerCategory(theCategory);
            model.addAttribute("message","Category Created successfully");
        }else {
            model.addAttribute("error","Failed to create category");
        }

        // Refresh lists for form rendering again
        model.addAttribute("theProductCategory", productCategoryService.getAllCategory());
        model.addAttribute("theCategory", new ProductCategory());
        model.addAttribute("productTypes", productTypeService.findProductTypeByActive(true));
        model.addAttribute("createCategory", new ProductCategory());


        return "admin/productCategory";
    }






}
