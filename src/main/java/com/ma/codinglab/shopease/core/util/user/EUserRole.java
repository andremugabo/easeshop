package com.ma.codinglab.shopease.core.util.user;

public enum EUserRole {
    ADMIN,          // System administrator with full access
    CUSTOMER,       // Regular user placing orders or using the platform
    VENDOR,         // Seller or service provider, if applicable
    MODERATOR,      // Can moderate content, users, reviews, etc.
    STAFF,          // Internal team members, limited admin rights
    SUPER_ADMIN     // For master control, typically one user only
}
