package com.ma.codinglab.shopease.core.Notification.model;

import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.userNotification.model.UserNotification;
import com.ma.codinglab.shopease.core.util.notification.ENotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Notification extends AbstractBaseEntity {
    private ENotificationType notificationType;
    @Lob
    private String message;
    @OneToMany(mappedBy = "notification")
    List<UserNotification> userNotifications;
}
