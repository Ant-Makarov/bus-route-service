package com.fintechband.models;

import com.fintechband.util.PaymentStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Data
@Builder(toBuilder = true)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "owners_name", columnDefinition = "varchar(255)", nullable = false)
    private String ownersName;

    @Column(name = "route_id", columnDefinition = "bigint", nullable = false)
    private Long routeId;

    @Column(name = "payment_id", columnDefinition = "uuid")
    private UUID paymentId;

    @Column(name = "payment_status", columnDefinition = "varchar(20)")
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "created", columnDefinition = "timestamp")
    private LocalDateTime created;

    @Column(name = "updated", columnDefinition = "timestamp")
    private LocalDateTime updated;
}
