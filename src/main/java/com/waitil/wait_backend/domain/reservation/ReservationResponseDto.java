package com.waitil.wait_backend.domain.reservation;

import lombok.Getter;

@Getter
public class ReservationResponseDto {
    private final Long reservationId;
    private final Integer waitNumber;
    public ReservationResponseDto(Reservation r) {
        this.reservationId = r.getReservationId();
        this.waitNumber = r.getWaitNumber();
    }
}