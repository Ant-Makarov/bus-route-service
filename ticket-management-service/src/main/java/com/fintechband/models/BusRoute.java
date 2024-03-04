package com.fintechband.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class BusRoute {
    private Long id;
    private String from;
    private String to;
    private LocalDateTime departureTime;
    private BigDecimal price;
    private int seatsAvailable;
}
