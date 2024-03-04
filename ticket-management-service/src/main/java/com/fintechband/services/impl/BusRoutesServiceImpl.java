package com.fintechband.services.impl;

import com.fintechband.services.BusRoutesService;
import com.fintechband.util.TicketDTO;

public class BusRoutesServiceImpl implements BusRoutesService {
    @Override
    public boolean checkAvailability(TicketDTO dto) {
        return false;
    }
}
