package com.example.simpleapp.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StringNotFoundException extends RuntimeException{
    private final String message;

    public StringNotFoundException(String message) {
        super();
        this.message = message;
    }
}
