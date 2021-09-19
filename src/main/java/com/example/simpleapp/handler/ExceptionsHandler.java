package com.example.simpleapp.handler;

import com.example.simpleapp.exceptions.EmptyStorageException;
import com.example.simpleapp.exceptions.StringNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(EmptyStorageException.class)
    public ResponseEntity<Object> handleEmptyStorageException(EmptyStorageException ex) {
        log.error("EmptyStorageException: " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StringNotFoundException.class)
    public ResponseEntity<Object> handleStringNotFoundException(StringNotFoundException ex) {
        log.error("StringNotFoundException: " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
