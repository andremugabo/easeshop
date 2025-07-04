package com.ma.codinglab.shopease.core.userNotification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserNotificationDto {
    private String id;
    private String userId;
    private String notificationId;
    private boolean isRead;
}
