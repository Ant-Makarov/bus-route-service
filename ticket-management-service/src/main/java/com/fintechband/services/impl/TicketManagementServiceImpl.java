package com.fintechband.services.impl;

import com.fintechband.services.BusRoutesService;
import com.fintechband.services.PaymentsService;
import com.fintechband.services.TicketManagementService;
import com.fintechband.services.TicketsService;
import com.fintechband.util.TicketDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketManagementServiceImpl implements TicketManagementService {

    private final TicketsService ticketsService;
    private final BusRoutesService routesService;
    private final PaymentsService paymentsService;

    @Override
    public Map<Long, UUID> createTicket(TicketDTO dto) {
        if (routesService.checkAvailability(dto)) {

        }
    }

}
