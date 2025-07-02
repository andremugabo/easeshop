package com.ma.codinglab.shopease.core.util.order;

public enum EOrderStatus {
    PENDING,          // Order placed, awaiting payment or confirmation
    CONFIRMED,        // Payment confirmed / Order accepted
    PROCESSING,       // Order is being packed or prepared
    SHIPPED,          // Order has left the warehouse
    DELIVERED,        // Order has been delivered to the customer
    CANCELLED,        // Order was cancelled by user or admin
    RETURNED,         // Order was returned by customer
    FAILED,           // Payment or delivery failed
    REFUNDED          // Money refunded after cancellation or return
}
