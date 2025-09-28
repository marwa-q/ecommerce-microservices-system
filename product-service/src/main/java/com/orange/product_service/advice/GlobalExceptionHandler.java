package com.orange.product_service.advice;

import com.orange.product_service.common.MessageService;
import com.orange.product_service.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageService messageService;

    public GlobalExceptionHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex, Locale locale) {
        String msg = messageService.getMessage("error.generic", locale);
        return ResponseEntity.badRequest().body(ApiResponse.failure(msg));
    }
}
