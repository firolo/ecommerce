package com.grupo2bbva.ecommerce.repositories;

import com.grupo2bbva.ecommerce.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
