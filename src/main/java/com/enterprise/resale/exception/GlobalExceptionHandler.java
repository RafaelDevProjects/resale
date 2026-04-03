package com.enterprise.resale.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handle(RuntimeException ex, HttpServletRequest request) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 409);
        erro.put("error", "Conflict");
        erro.put("message", ex.getMessage());
        erro.put("path", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}