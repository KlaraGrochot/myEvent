package org.klarag.myevent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> handleEventNotFoundException(EventNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(RegistrationFullException.class)
    public ResponseEntity<String> handleRegistrationFullException(RegistrationFullException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(AlreadyRegisteredException.class)
    public ResponseEntity<String> handleAlreadyRegisteredException(AlreadyRegisteredException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
