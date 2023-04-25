package org.example.exception;

import org.springframework.http.HttpStatus;

public class DataBaseRuntimeException extends RuntimeException {
    public DataBaseRuntimeException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public DataBaseRuntimeException(String cause) {
        super(cause);
    }
}
