package com.waitil.wait_backend.domain.notification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequestDto {
    @NotNull(message = "예약 ID는 필수입니다.")
    private Long reservationId;
    @NotBlank(message = "메시지는 필수입니다.")
    private String message;
}