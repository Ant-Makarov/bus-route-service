package com.fintechband.services.impl;

import com.fintechband.dto.PaymentDTO;
import com.fintechband.models.Payment;
import com.fintechband.repositories.PaymentRepository;
import com.fintechband.services.PaymentService;
import com.fintechband.util.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final Clock clock;

    @Override
    public Map<String, UUID> createPayment(PaymentDTO dto) {
        return savePayment(dto);
    }

    private Map<String, UUID> savePayment(PaymentDTO dto) {
        Payment saved = repository.save(enrichPaymentEntity(convertToPayment(dto)));
        return Map.of("id", saved.getId());
    }

    private Payment enrichPaymentEntity(Payment payment) {
        return payment.toBuilder().status(PaymentStatus.getRandomStatus())
                                  .created(LocalDateTime.now(clock))
                                  .build();
    }

    private Payment convertToPayment(PaymentDTO dto) {
        return mapper.map(dto, Payment.class);
    }
}
