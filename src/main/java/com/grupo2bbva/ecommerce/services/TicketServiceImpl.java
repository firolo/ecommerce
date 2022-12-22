package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.TicketDTO;
import com.grupo2bbva.ecommerce.models.*;
import com.grupo2bbva.ecommerce.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketProductoRepository ticketProductoRepository;
    @Autowired
    CarritoProductoRepository carritoProductoRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    CarritoRepository carritoRepository;
    @Autowired
    EmailService emailService;

    @Override
    public String comprar(Cliente cliente) {
        Set<CarritoProducto> carritoProductos = cliente.getCarrito().getCarritoProductos();
        double sumaProductos = 0d;
        for (CarritoProducto carritoProducto : carritoProductos) {
            Producto producto = productoRepository.findById(carritoProducto.getProducto().getId()).orElse(null);
            if(producto.getStock().compareTo((long) carritoProducto.getCantidadProductos())>=0) {
                producto.setStock(producto.getStock()-carritoProducto.getCantidadProductos());
                productoRepository.save(producto);
            } else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return "Cantidad de producto "+carritoProducto.getProducto().getNombre()+" insuficiente";
            }
            sumaProductos = sumaProductos + carritoProducto.getMonto();
        }

        Ticket ticket = new Ticket(sumaProductos,sumaProductos, LocalDateTime.now(), cliente);
        Set<TicketProducto> ticketProductos = carritoProductos.stream().
                map(carritosProductos -> {return new TicketProducto(carritosProductos, ticket);}).collect(Collectors.toSet());

        ticketRepository.save(ticket);
        for (TicketProducto ticketProducto : ticketProductos) {
            ticketProductoRepository.save(ticketProducto);
        }

        /* vaciar carrito */
        for (CarritoProducto carritoProducto : carritoProductos) {
            carritoProductoRepository.delete(carritoProducto);
        }

        sendMail(carritoProductos, cliente);
        cliente.getCarrito().setMontoTotal(0);
        carritoRepository.save(cliente.getCarrito());


        return "Compra OK";

    }

    @Override
    public Set<TicketDTO> getCompras(Cliente cliente) {
        return ticketRepository.findAll().stream().map(TicketDTO::new).collect(Collectors.toSet());
    }

    public void sendMail(Set<CarritoProducto> productos, Cliente cliente) {
        String cuerpo = "";

        for (CarritoProducto producto : productos) {
            cuerpo += "Producto: " + producto.getProducto().getNombre() + "\n";
            cuerpo += "Cantidad: " + producto.getCantidadProductos() + "\n";
            cuerpo += "Monto: " + producto.getMonto() + "\n";
            cuerpo += "-----------------------------------------\n";
        }

        cuerpo += "Total: $" + cliente.getCarrito().getMontoTotal();

        emailService.sendEmail("raffi.kocak13@gmail.com", "Compra realizada " + LocalDate.now(), cuerpo);
//        emailService.sendEmail(cliente.getEmail(), "Compra realizada " + LocalDate.now(), cuerpo);
    }
}
