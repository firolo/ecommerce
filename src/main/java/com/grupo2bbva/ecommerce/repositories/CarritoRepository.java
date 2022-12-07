package com.grupo2bbva.ecommerce.repositories;

import com.grupo2bbva.ecommerce.models.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito,Long> {
}
