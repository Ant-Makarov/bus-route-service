package com.fintechband.services;

import com.fintechband.dto.PaymentDTO;
import com.fintechband.util.PaymentStatus;

import java.util.Map;
import java.util.UUID;

public interface PaymentsService {

    Map<String, UUID> createPayment(PaymentDTO dto);

    Map<UUID, PaymentStatus> getPaymentStatus(UUID id);
}
