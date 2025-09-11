package com.waitil.wait_backend.domain.notification;

import lombok.Getter;

@Getter
public class NotificationResponseDto {
    private final Long id;
    private final String message;

    public NotificationResponseDto(Notification n) {
        this.id = n.getNotificationId();
        this.message = n.getMessage();
    }
}