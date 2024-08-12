package com.fintech_band.payment_system.services.impl;

import com.fintech_band.payment_system.models.dto.PaymentDTO;
import com.fintech_band.payment_system.repositories.PaymentsRepository;
import com.fintech_band.payment_system.services.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentsServiceImpl implements PaymentsService {

    private final Clock clock;
    private final PaymentsRepository repository;
//    private final ModelMapper mapper;
    @Override
    public Map<UUID, String> createPayment(PaymentDTO dto) {
        return null;
    }
}
