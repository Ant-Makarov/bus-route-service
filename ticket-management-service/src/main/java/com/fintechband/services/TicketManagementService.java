package com.fintechband.services;

import com.fintechband.util.TicketDTO;

import java.util.Map;
import java.util.UUID;

public interface TicketManagementService {
    Map<Long, UUID> createTicket(TicketDTO dto);
}
