package com.waitil.wait_backend.domain.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequestDto {
    @NotBlank(message = "이름은 필수입니다.")
    private String name;
    @NotBlank(message = "주소는 필수입니다.")
    private String address;
    private String description;
}
