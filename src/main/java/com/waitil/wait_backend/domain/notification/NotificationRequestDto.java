package com.waitil.wait_backend.domain.notification;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class NotificationRequestDto {
    @NotNull(message = "예약 ID는 필수입니다.")
    private Long reservationId;
    @NotBlank(message = "메시지는 필수입니다.")
    private String message;
}