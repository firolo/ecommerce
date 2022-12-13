package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CarritoDTO;
import com.grupo2bbva.ecommerce.models.Carrito;

import java.util.List;

public interface CarritoService {
    List<Carrito> findAll();

    List<CarritoDTO> findAllDTO();

    Carrito findById(Long id);

    CarritoDTO findByIdDTO(Long id);
}
