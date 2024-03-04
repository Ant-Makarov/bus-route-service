package com.fintechband.controllers;

import com.fintechband.dto.PaymentDTO;
import com.fintechband.exceptions.PaymentCreationException;
import com.fintechband.services.PaymentsService;
import com.fintechband.util.Code;
import com.fintechband.util.PaymentStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.fintechband.exceptions.PaymentCreationException.createErrorMessage;
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class PaymentsController {

    private final PaymentsService paymentsService;

    @PostMapping("/payments")
    public Map<String, UUID> createPayment(@RequestBody @Valid PaymentDTO dto, BindingResult bindingResult) {
        log.info("Received payment creation request with PAYLOAD : {}", dto);
        if (bindingResult.hasErrors()) {
            throw new PaymentCreationException(Code.VALIDATION_ERROR, createErrorMessage(bindingResult),
                    HttpStatus.BAD_REQUEST);
        }

        return paymentsService.createPayment(dto);
    }

    @GetMapping("/payments/{id}/status")
    public Map<UUID, PaymentStatus> getPaymentStatus(@PathVariable(name = "id") UUID id) {
        log.info("Received payment status request with PAYLOAD : {}", id);
        return paymentsService.getPaymentStatus(id);
    }
}
