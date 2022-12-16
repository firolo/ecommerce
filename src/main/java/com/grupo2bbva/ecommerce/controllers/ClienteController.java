package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.ClienteDTO;
import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;



    @PostMapping("/clients")
    public ResponseEntity<Object> registrarCliente(@RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String email, @RequestParam String password) {

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Faltan datos", HttpStatus.FORBIDDEN);
        }

        if (clienteService.findByEmail(email) != null) {
            return new ResponseEntity<>("Usuario ya existente", HttpStatus.FORBIDDEN);
        }

        Cliente cliente = clienteService.generateCliente(nombre, apellido, email, password);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

/*    @GetMapping("/clients/current")
    public ClienteDTO getClientByEmail(Authentication authentication) {
        return clienteService.getByAuthenticationDTO(authentication);
    }*/

}
