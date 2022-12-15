package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.ProductoDTO;
import com.grupo2bbva.ecommerce.dtos.ProductoDTOApplication;
import com.grupo2bbva.ecommerce.models.Producto;

import java.util.Set;

public interface ProductoService {
    Set<ProductoDTO> getAll();

    Producto findById(Long id);

    ProductoDTO findByIdDTO(Long id);

    boolean create(ProductoDTOApplication productoDTOApplication);
    boolean update(ProductoDTOApplication productoDTOApplication);
    boolean delete(Long id);
}
