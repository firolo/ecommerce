package com.grupo2bbva.ecommerce.repositories;

import com.grupo2bbva.ecommerce.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
