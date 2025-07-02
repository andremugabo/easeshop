package com.ma.codinglab.shopease.core.util.payment;

public enum EPaymentStatus {
    PENDING,          // Payment initiated but not completed yet
    PROCESSING,       // Payment is being verified or processed
    COMPLETED,        // Payment was successful
    FAILED,           // Payment failed (e.g., insufficient funds)
    CANCELLED,        // Payment was cancelled by the user or system
    REFUNDED,         // Payment was refunded to the user
    CHARGEBACK,       // Payment disputed and reversed by the payment provider
    EXPIRED           // Payment session/ticket expired without completion
}
