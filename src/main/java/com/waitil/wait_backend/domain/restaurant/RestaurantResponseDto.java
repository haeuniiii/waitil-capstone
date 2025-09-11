package com.waitil.wait_backend.domain.restaurant;

import lombok.Getter;

@Getter
public class RestaurantResponseDto {
    private final Long restaurantId;
    private final String name;
    public RestaurantResponseDto(Restaurant r) {
        this.restaurantId = r.getRestaurantId();
        this.name = r.getName();
    }
}