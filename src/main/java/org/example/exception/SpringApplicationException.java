package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SpringApplicationException {
    private final String errorMessage;
    private final Integer errorCode;
}
