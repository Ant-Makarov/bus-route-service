package com.fintechband.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class PaymentServiceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Response> handleException(PaymentCreationException e) {
        log.debug(e.toString());
        return new ResponseEntity<>(getErrorEntity(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Response> handleException(PaymentNotFoundException e) {
        log.debug(e.toString());
        return new ResponseEntity<>(getErrorEntity(e), HttpStatus.NOT_FOUND);
    }

    private Error getErrorEntity(PaymentServiceApplicationException e) {
        return Error.builder().code(e.getCode())
                              .message(e.getMessage())
                              .status(e.getStatus())
                              .build();
    }
}
