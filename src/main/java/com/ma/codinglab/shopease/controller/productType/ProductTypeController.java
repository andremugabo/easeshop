package com.ma.codinglab.shopease.controller.productType;


import com.ma.codinglab.shopease.core.productType.dto.ProductTypeDTO;
import com.ma.codinglab.shopease.core.productType.model.ProductType;
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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productType")
public class ProductTypeController {

    private final IProductTypeService productTypeService;

    @GetMapping("/productTypePage")
    public String getProductType(Model model){
        List<ProductType> theProduct = productTypeService.findProductTypeByActive(Boolean.TRUE);
        model.addAttribute("productTypes",theProduct);
        model.addAttribute("theProductType", new ProductTypeDTO());
        return "admin/productTypePage";
    }

    @PostMapping("/productTypePage")
    public String addProductType(@ModelAttribute("theProductType") ProductTypeDTO theProductTypeDto, Model model){
        if(Objects.nonNull(theProductTypeDto)){
            productTypeService.createProductType(theProductTypeDto);
            model.addAttribute("message","Product Type recorded successfully");
        }else{
           model.addAttribute("error","Data not Saved !!!");
        }
        return "redirect:/productType/productTypePage";
    }





}
