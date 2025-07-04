package com.ma.codinglab.shopease.core.address.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    private String id;
    private String street;
    private String city;
    private boolean active;

    private String userId; // Reference to the associated user
}
