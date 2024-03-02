package com.fintechband.exceptions;

import com.fintechband.util.Code;
import org.springframework.http.HttpStatus;

public class PaymentNotFoundException extends PaymentServiceApplicationException {
    public PaymentNotFoundException(Code code, String message, HttpStatus status) {
        super(code, message, status);
    }
}
