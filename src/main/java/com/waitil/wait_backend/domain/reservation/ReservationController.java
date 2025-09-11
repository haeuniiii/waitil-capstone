package com.waitil.wait_backend.domain.reservation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public ReservationResponseDto createReservation(@RequestBody @Valid ReservationRequestDto dto) {
        return new ReservationResponseDto(reservationService.create(dto));
    }
}
