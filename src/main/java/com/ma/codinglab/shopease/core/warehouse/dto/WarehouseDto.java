package com.ma.codinglab.shopease.core.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDto {
    private UUID id;
    private String name;
    private String location;
    private String regNumber;
    private List<Long> productIds;
}
