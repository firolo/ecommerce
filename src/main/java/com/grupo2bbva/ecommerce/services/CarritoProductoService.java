package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CarritoProductoDTO;
import com.grupo2bbva.ecommerce.models.CarritoProducto;

import java.util.List;
import java.util.Optional;

public interface CarritoProductoService {
    List<CarritoProducto> findAll();

    List<CarritoProductoDTO> findAllDTO();

    CarritoProducto findById(Long id);

    CarritoProductoDTO findByIdDTO(Long id);
}
