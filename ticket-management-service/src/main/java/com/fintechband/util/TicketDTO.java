package com.fintechband.util;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TicketDTO {

    @NotBlank
    @Size(min = 2, max = 255, message = "Payers name size should be between 2 and 255 characters!")
    @JsonAlias(value = "nameOfPayer")
    private String ownersName;
    @NotNull
    @Pattern(regexp = "^1\\d{7}$")
    private Long routeId;
}
