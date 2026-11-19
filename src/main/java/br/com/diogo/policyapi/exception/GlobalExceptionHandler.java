package br.com.diogo.policyapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValuePremiumException.class)
    public ResponseEntity<String> handle(ValuePremiumException e) {
        return ResponseEntity.badRequest().body(e.getMessage());}
}


