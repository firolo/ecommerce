package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CategoriaDTO;
import com.grupo2bbva.ecommerce.models.Categoria;

import java.util.Set;

public interface CategoriaService {
    Set<CategoriaDTO> getAll();
    Categoria create(String nombre);
}
