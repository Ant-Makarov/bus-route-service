package com.fintechband.exceptions;

import com.fintechband.util.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class PaymentCreationException extends PaymentServiceApplicationException {

    public PaymentCreationException(Code code, String message, HttpStatus status) {
        super(code, message, status);
    }

    public static String createErrorMessage(BindingResult result) {
        StringBuffer buffer = new StringBuffer();
        for (FieldError e : result.getFieldErrors()) {
            buffer.append(e.getField())
                  .append(" - ")
                  .append(e.getDefaultMessage())
                  .append(" ; ");
        }
        buffer.trimToSize();
        return buffer.toString();
    }
}
