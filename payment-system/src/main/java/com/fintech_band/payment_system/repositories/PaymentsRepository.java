package com.fintech_band.payment_system.repositories;

import com.fintech_band.payment_system.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentsRepository extends JpaRepository<Payment, UUID> {
}
