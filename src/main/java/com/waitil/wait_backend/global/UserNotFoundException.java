package com.waitil.wait_backend.global;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends WaitilException {
    public UserNotFoundException() {
        super("사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
    }
}
