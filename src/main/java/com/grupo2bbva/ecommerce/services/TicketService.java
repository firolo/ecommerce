package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.TicketDTO;
import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.models.Ticket;

import java.util.Set;

public interface TicketService {
    String comprar(Cliente cliente);

    Set<TicketDTO> getCompras(Cliente cliente);
}
