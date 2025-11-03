package com.waitil.wait_backend.domain.reservation;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class ReservationRequestDto {
    @NotNull(message = "사용자 ID는 필수입니다.")
    private Long userId;
    @NotNull(message = "음식점 ID는 필수입니다.")
    private Long restaurantId;
}