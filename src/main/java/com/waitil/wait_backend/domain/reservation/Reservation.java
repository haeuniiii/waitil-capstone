package com.waitil.wait_backend.domain.reservation;

import com.waitil.wait_backend.domain.user.User;
import com.waitil.wait_backend.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservations")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false)
    private String status; // WAITING, CALLED, CANCELLED 등

    @Column(nullable = false)
    private Integer waitNumber;

    @Column(nullable = false)
    private String reservationTime;
}
