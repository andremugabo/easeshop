package com.ma.codinglab.shopease.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopEaseRouterController {
    @GetMapping("/")
    public String homepage(){
        return "index";
    }
    @GetMapping("/categories")
    public String categories(){
        return "categories/index";
    }
    @GetMapping("/products")
    public String products(){
        return "products/index";
    }
    @GetMapping("/sales")
    public String sales(){
        return "sales/index";
    }
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }


}
