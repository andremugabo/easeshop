package com.ma.codinglab.shopease.controller.customer;

import com.ma.codinglab.shopease.core.customer.model.Customer;
import com.ma.codinglab.shopease.core.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/")
    public String display(Model model){
        return "/customer/index";
    }

}
