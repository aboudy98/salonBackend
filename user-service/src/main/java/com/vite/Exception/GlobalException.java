package com.vite.Exception;

import java.time.LocalDate;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vite.Payload.PayloadResponse.ExceptionResponse;

@ControllerAdvice
public class GlobalException {
   @ExceptionHandler(Exception.class)
public ResponseEntity<ExceptionResponse> handleException(Exception ex, WebRequest req) {

    ExceptionResponse response = new ExceptionResponse(
        ex.getMessage(),
        req.getDescription(false),
        LocalDate.now() 
    );
    return ResponseEntity.ok(response);
}

    
}
