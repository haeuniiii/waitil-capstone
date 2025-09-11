package com.waitil.wait_backend.domain.restaurant;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public RestaurantResponseDto createRestaurant(@RequestBody @Valid RestaurantRequestDto dto) {
        return new RestaurantResponseDto(restaurantService.create(dto));
    }
}
