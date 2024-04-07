package com.hotelservice.HotelService.exceptions;

import com.hotelservice.HotelService.payloads.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> getResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponseMessage message = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
