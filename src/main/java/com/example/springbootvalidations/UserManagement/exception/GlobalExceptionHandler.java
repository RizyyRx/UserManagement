package com.example.springbootvalidations.UserManagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
 
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<String> handleValidationError(MethodArgumentNotValidException ex) {
       String errorMessage = ex.getBindingResult()
           .getFieldErrors()
           .stream()
           .map(error -> error.getField() + ": " + error.getDefaultMessage())
           .findFirst()
           .orElse("Validation error");
       return ResponseEntity.badRequest().body(errorMessage);
   }
}
