package com.fintechband.services.impl;

import com.fintechband.dto.PaymentDTO;
import com.fintechband.exceptions.PaymentNotFoundException;
import com.fintechband.models.Payment;
import com.fintechband.repositories.PaymentRepository;
import com.fintechband.services.PaymentService;
import com.fintechband.util.Code;
import com.fintechband.util.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Map<String, UUID> createPayment(PaymentDTO dto) {
        return savePayment(dto);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Map<UUID, PaymentStatus> getPaymentStatus(UUID id) {
        return getRandomStatus(id);
    }

    private Map<String, UUID> savePayment(PaymentDTO dto) {
        Payment saved = repository.save(enrichPaymentEntity(convertToPayment(dto)));
        return Map.of("id", saved.getId());
    }

    private Payment enrichPaymentEntity(Payment payment) {
        return payment.toBuilder().status(PaymentStatus.NEW)
                                  .created(LocalDateTime.now(clock))
                                  .build();
    }

    private Payment convertToPayment(PaymentDTO dto) {
        return mapper.map(dto, Payment.class);
    }

    private Map<UUID, PaymentStatus> getRandomStatus(UUID id) {
       return Map.of(id, updatePayment(id));
    }

    private PaymentStatus updatePayment(UUID id) {
        Payment payment = repository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(Code.VALIDATION_ERROR,
                        String.format("Payment with id %s wasn't found!", id), HttpStatus.NOT_FOUND));
        PaymentStatus status = PaymentStatus.getRandomStatus();
        payment.setStatus(status);
        payment.setUpdated(LocalDateTime.now(clock));
        return status;
    }
}
