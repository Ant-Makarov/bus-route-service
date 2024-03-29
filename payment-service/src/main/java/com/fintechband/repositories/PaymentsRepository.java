package com.fintechband.repositories;

import com.fintechband.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment, UUID> {
}
