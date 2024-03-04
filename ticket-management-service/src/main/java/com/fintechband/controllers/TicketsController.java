package com.fintechband.controllers;

import com.fintechband.services.TicketManagementService;
import com.fintechband.services.TicketsService;
import com.fintechband.util.TicketDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class TicketsController {

    private final TicketManagementService managementService;

    @PostMapping
    public Map<Long, UUID> createTicket(@RequestBody @Valid TicketDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException();
        }

        return managementService.createTicket(dto);
    }
}
