package com.waitil.wait_backend.domain.restaurant;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurants")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    private String address;

    private String phone;

    private String imageUrl;

    private String category;
}
