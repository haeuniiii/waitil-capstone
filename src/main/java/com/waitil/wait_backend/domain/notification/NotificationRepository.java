package com.waitil.wait_backend.domain.notification;

import com.waitil.wait_backend.domain.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}