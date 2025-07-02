package core.address.model;

import core.base.AbstractBaseEntity;
import core.user.model.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address  extends AbstractBaseEntity {

    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "city", nullable = false)
    private String city;
    @ManyToOne
    @JoinColumn(name = "id")
    private Users user;
}
