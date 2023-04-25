package org.example.exception;

import org.example.service.dto.TagDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<TagDto> generateException(ResponseStatusException responseStatusException) {
        TagDto dto = new TagDto();
        dto.setName("asd");
        return new ResponseEntity<TagDto>(dto, HttpStatus.NOT_FOUND);
    }
}
