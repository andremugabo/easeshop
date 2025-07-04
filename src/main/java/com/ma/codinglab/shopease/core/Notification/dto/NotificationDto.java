package com.ma.codinglab.shopease.core.Notification.dto;

import com.ma.codinglab.shopease.core.userNotification.dto.UserNotificationDto;
import com.ma.codinglab.shopease.core.util.notification.ENotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private String id;
    private ENotificationType notificationType;
    private String message;
    private List<UserNotificationDto> userNotifications;

}
