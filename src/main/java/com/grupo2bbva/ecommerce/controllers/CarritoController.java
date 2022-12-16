package com.grupo2bbva.ecommerce.controllers;


import com.grupo2bbva.ecommerce.dtos.CarritoProductoDTO;
import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.repositories.ClienteRepository;
import com.grupo2bbva.ecommerce.services.CarritoService;
import com.grupo2bbva.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/verCarrito")
    public ResponseEntity<?> mostrarProductosEnCarrito(Authentication authentication) {
        if (authentication != null) {
            Cliente cliente = clienteService.findByEmail(authentication.getName());

            if (cliente != null) {
                return new ResponseEntity<>(carritoService.findProductosByClienteDTO(cliente), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }
}
