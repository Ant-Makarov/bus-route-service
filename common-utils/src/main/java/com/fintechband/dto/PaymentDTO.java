package com.fintechband.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class PaymentDTO {

    @NotBlank
    @Size(min = 2, max = 255, message = "Payers name size should be between 2 and 255 characters!")
    @JsonAlias(value = "nameOfPayer")
    private String payersName;

    @Digits(integer = 5, fraction = 2)
    @DecimalMin(value = "1000", message = "Payment amount couldn't be lower than 1000!")
    @NotNull
    private BigDecimal amount;
}
