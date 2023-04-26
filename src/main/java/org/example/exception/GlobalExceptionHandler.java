package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<SpringApplicationException> handleSpringApplicationException(NotFoundException exception) {
        String errorMessage = exception.getMessage();
        SpringApplicationException body = new SpringApplicationException(errorMessage, ErrorCode.ENTITY_NOT_FOUND_CODE);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
