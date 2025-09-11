package com.waitil.wait_backend.domain.notification;

import com.waitil.wait_backend.domain.reservation.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification create(NotificationRequestDto dto) {
        return notificationRepository.save(Notification.builder()
                .reservation(Reservation.builder()
                        .reservationId(dto.getReservationId())
                        .build())
                .message(dto.getMessage())
                .build());
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }
}
