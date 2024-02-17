package com.fintechband.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class PaymentDTO {

    @Size(min = 2, max = 255, message = "Payers name size should be between 2 and 255 characters!")
    private String payersName;

    @Digits(integer = 5, fraction = 2)
    @DecimalMin(value = "1000")
    @NotNull
    private BigDecimal amount;
}
