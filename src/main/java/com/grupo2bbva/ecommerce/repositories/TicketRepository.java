package com.grupo2bbva.ecommerce.repositories;

import com.grupo2bbva.ecommerce.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
