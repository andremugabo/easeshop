package com.ma.codinglab.shopease.core.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private Integer likeCount;
    private Boolean approved;
    private Boolean verifiedPurchase;
    private Long productId;
    private Long userId;
}
