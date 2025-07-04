package com.ma.codinglab.shopease.core.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    private String id;
    private LocalDate date;
    private String paymentStatus;
    private String paymentCurrencyType;
    private String paymentMode;
    private String transactionId;
    private Double amount;

    private String orderId;
    private String userId;
}
