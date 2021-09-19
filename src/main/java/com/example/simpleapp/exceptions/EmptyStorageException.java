package com.example.simpleapp.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmptyStorageException extends RuntimeException {
    private final String message;

    public EmptyStorageException(String message) {
        super();
        this.message = message;
    }
}