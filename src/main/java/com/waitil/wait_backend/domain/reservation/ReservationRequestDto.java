package com.waitil.wait_backend.domain.reservation;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequestDto {
    @NotNull(message = "사용자 ID는 필수입니다.")
    private Long userId;
    @NotNull(message = "음식점 ID는 필수입니다.")
    private Long restaurantId;
}