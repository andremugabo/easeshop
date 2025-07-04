package com.ma.codinglab.shopease.core.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private String id;
    private LocalDateTime date;
    private String orderStatus;
    private Integer quantity;
    private Double totalAmount;

    private String productId;
    private String productName;

    private String userId;
    private String userFullName;

    private List<String> paymentIds;
}
