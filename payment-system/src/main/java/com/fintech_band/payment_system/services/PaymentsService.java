package com.fintech_band.payment_system.services;

import com.fintech_band.payment_system.models.dto.PaymentDTO;

import java.util.Map;
import java.util.UUID;

public interface PaymentsService {
    Map<UUID, String> createPayment(PaymentDTO dto);
}
