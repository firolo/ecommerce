package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.models.CarritoProducto;
import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.models.Ticket;
import com.grupo2bbva.ecommerce.models.TicketProducto;
import com.grupo2bbva.ecommerce.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public String comprar(Cliente cliente) {
        Set<CarritoProducto> carritoProductos = cliente.getCarrito().getCarritoProductos();
        double sumaProductos = 0d;
        for (CarritoProducto carritoProducto : carritoProductos) {
            sumaProductos = sumaProductos + carritoProducto.getMonto();
        }

        Ticket ticket = new Ticket(sumaProductos,sumaProductos, LocalDateTime.now());
        Set<TicketProducto> ticketProductos = carritoProductos.stream().
                map(carritosProductos -> {return new TicketProducto(carritosProductos, ticket);}).collect(Collectors.toSet());

        ticketRepository.save(ticket);
        for (CarritoProducto carritoProducto : carritoProductos) {

        }

        return "Compra OK";

    }
}
