package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.models.Cliente;

public interface ClienteService {

    Cliente findByEmail(String email);
    Cliente generateCliente(String nombre, String apellido, String email, String password);

}
