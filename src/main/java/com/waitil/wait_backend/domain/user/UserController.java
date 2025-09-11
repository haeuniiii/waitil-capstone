package com.waitil.wait_backend.domain.user;

import com.waitil.wait_backend.domain.user.dto.UserRequestDto;
import com.waitil.wait_backend.domain.user.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto dto) {
        return new UserResponseDto(userService.create(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRequestDto requestDto) {
        userService.register(requestDto);
        return ResponseEntity.ok("회원가입 완료");
    }
}
