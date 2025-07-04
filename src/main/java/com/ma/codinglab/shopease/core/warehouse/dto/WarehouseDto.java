package com.ma.codinglab.shopease.core.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDto {
    private Long id;
    private String name;
    private String location;
    private String regNumber;
    private List<Long> productIds;
}
