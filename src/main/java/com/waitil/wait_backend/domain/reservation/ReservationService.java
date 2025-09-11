package com.waitil.wait_backend.domain.reservation;

import com.waitil.wait_backend.domain.restaurant.Restaurant;
import com.waitil.wait_backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation create(ReservationRequestDto dto) {
        return reservationRepository.save(Reservation.builder()
                .user(User.builder().userId(dto.getUserId()).build())
                .restaurant(Restaurant.builder().restaurantId(dto.getRestaurantId()).build())
                .waitNumber(generateWaitNumber())
                .build());
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    private int generateWaitNumber() {
        return ThreadLocalRandom.current().nextInt(1, 1000);
    }
}
