package com.ma.codinglab.shopease.controller.warehouse;


import com.ma.codinglab.shopease.core.warehouse.model.Warehouse;
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
@RequestMapping("/warehouse")
public class WarehouseController {

    private final IWarehouseService warehouseService;

    @GetMapping("/warehousePage")
    public String getAllWarehouse(Model model){
        List<Warehouse> theWarehouse = warehouseService.findActiveWarehouse(Boolean.TRUE);
        model.addAttribute("theWarehouses", theWarehouse);
        model.addAttribute("oneTheWarehouse", new Warehouse());
        return "admin/warehousePage";

    }
    @PostMapping("/createWarehouse")
    public String registerWarehouse(@ModelAttribute("oneTheWarehouse") Warehouse theWarehouse, Model model){
            if(Objects.nonNull(theWarehouse)){
                warehouseService.registerWarehouse(theWarehouse);
                model.addAttribute("message", "Warehouse registered successfully ");
            } else {
                model.addAttribute("error","Failed to register warehouse");
            }
        return "admin/warehousePage";
    }

}
