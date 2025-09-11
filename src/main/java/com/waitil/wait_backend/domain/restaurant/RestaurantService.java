package com.waitil.wait_backend.domain.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant create(RestaurantRequestDto dto) {
        return restaurantRepository.save(Restaurant.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .build());
    }
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
