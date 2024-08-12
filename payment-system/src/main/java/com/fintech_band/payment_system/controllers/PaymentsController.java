package com.fintech_band.payment_system.controllers;

import com.fintech_band.payment_system.exceptions.PaymentSystemException;
import com.fintech_band.payment_system.models.dto.PaymentDTO;
import com.fintech_band.payment_system.services.PaymentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PaymentsController {

    private final PaymentsService paymentsService;

    @PostMapping("/payments")
    public Map<UUID, String> createPayment(@Valid @RequestBody PaymentDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new PaymentSystemException();

        return paymentsService.createPayment(dto);
    }
}
