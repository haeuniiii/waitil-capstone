package com.waitil.wait_backend.global;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid DTO 검증 실패 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }

    // 커스텀 예외 처리
    @ExceptionHandler(WaitilException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(WaitilException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ErrorResponse(ex.getMessage()));
    }

    // 기타 서버 오류
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ex.printStackTrace(); // 로그 출력
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("서버 내부 오류가 발생했습니다."));
    }

    // 오류 응답 DTO
    public record ErrorResponse(String message) {}
}
