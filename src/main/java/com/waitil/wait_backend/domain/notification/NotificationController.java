package com.waitil.wait_backend.domain.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PostMapping
    public NotificationResponseDto create(@RequestBody @Valid NotificationRequestDto dto) {
        return new NotificationResponseDto(notificationService.create(dto));
    }
}
