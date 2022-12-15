package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.TicketDTO;
import com.grupo2bbva.ecommerce.dtos.TicketDTOApplication;
import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.services.ClienteService;
import com.grupo2bbva.ecommerce.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Autowired
    ClienteService clienteService;

    /* efectivizar la compra */
    @PostMapping("/comprar")
    ResponseEntity<Object> comprar(Authentication authentication) {
        if (authentication != null) {
            Cliente cliente = clienteService.findByEmail(authentication.getName());

            if (cliente != null) {
                String resultado = ticketService.comprar(cliente);
                if(resultado.equals("Compra OK")) {
                    return new ResponseEntity<>(resultado, HttpStatus.OK);
                } else
                    return new ResponseEntity<>(resultado, HttpStatus.FORBIDDEN);
            }
        }

        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

    /* simulacion de validacion de tarjeta*/
    @PostMapping("/pagar")
    ResponseEntity<Object> pagar (Authentication authentication, @RequestBody TicketDTOApplication ticketDTOApplication) {
        if (authentication != null) {
            Cliente cliente = clienteService.findByEmail(authentication.getName());

            if (ticketDTOApplication.getCantCuotas() == 0 || ticketDTOApplication.getNumeroTarjeta() == null ) {
                return new ResponseEntity<>("Faltan ingresar parametros", HttpStatus.FORBIDDEN);
            }

            return new ResponseEntity<>("OK", HttpStatus.OK);
        }

        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

}
