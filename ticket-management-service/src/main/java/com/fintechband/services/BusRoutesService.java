package com.fintechband.services;

import com.fintechband.util.TicketDTO;

public interface BusRoutesService {
    boolean checkAvailability(TicketDTO dto);
}
