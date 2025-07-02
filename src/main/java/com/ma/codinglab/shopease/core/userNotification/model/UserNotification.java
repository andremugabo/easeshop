package com.ma.codinglab.shopease.core.userNotification.model;

import com.ma.codinglab.shopease.core.Notification.model.Notification;
import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
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
@Table(name = "usernotification")
public class UserNotification extends AbstractBaseEntity {
    private Boolean isRead = Boolean.FALSE;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

}
