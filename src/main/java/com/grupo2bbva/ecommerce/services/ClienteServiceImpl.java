package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Cliente generateCliente(String nombre, String apellido, String email, String password) {
//        Cliente client = new Cliente(nombre, apellido, email, passwordEncoder.encode(password));
        Cliente client = new Cliente(nombre, apellido, email, password);
        clienteRepository.save(client);
        return client;
    }
}
