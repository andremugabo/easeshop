package com.ma.codinglab.shopease.core.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Getter @Setter
@MappedSuperclass
public abstract class AbstractBaseEntity extends AbstractAuditEntity {
    @UuidGenerator
    @Id
    private UUID Id;
    @Column(name = "active",nullable = false)
    private Boolean active = Boolean.TRUE;
}
