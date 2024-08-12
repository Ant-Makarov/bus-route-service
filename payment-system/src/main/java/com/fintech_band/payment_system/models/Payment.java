package com.fintech_band.payment_system.models;

import com.fintech_band.payment_system.util.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="payment")
public class Payment {

    @Id
    private UUID id;

    @Column(name = columnDefinition = "varchar(255)", nullable = false)
    private String payersName;
    @Column(columnDefinition = "numeric(7,2)", nullable = false)
    private BigDecimal amount;
    @Basic
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PaymentStatus status;

}
