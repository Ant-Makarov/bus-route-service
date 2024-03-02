package com.fintechband.exceptions;

import com.fintechband.util.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class PaymentServiceApplicationException extends RuntimeException {
    private Code code;
    private String message;
    private HttpStatus status;
}
