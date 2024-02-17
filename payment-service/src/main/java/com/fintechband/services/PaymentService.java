package com.fintechband.services;

import com.fintechband.dto.PaymentDTO;

import java.util.Map;
import java.util.UUID;

public interface PaymentService {

    Map<String, UUID> createPayment(PaymentDTO dto);
}
