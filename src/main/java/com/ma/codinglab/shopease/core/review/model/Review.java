package com.ma.codinglab.shopease.core.review.model;

import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.product.models.Product;
import com.ma.codinglab.shopease.core.user.model.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "review")
public class Review extends AbstractBaseEntity {
    private Integer likeCount;
    private Boolean approved = Boolean.FALSE;
    private Boolean verifiedPurchase;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
