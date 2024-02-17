package com.fintechband.models;

import com.fintechband.util.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "payers_name", columnDefinition = "varchar(255)")
    private String payersName;

    @Column(name = "amount", columnDefinition = "numeric(7,2)")
    private BigDecimal amount;

    @Column(name = "status", columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "created", columnDefinition = "timestamp")
    private LocalDateTime created;

    @Column(name = "updated", columnDefinition = "timestamp")
    private LocalDateTime updated;
}
