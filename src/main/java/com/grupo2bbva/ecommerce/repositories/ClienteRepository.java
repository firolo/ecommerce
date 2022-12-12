package com.grupo2bbva.ecommerce.repositories;

import com.grupo2bbva.ecommerce.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
