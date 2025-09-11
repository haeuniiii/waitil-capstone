package com.waitil.wait_backend.domain.user;

import com.waitil.wait_backend.domain.user.dto.UserRequestDto;
import com.waitil.wait_backend.global.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long userId) {
        // 사용자 없으면 예외 발생
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User create(UserRequestDto dto) {
        User user = User.builder()
                .socialId(dto.getSocialId())
                .provider(dto.getProvider())
                .nickname(dto.getNickname())
                .profileImage(dto.getProfileImage())
                .build();

        return userRepository.save(user);
    }

    public void register(UserRequestDto dto) {
        create(dto);
    }
}
