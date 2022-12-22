package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CategoriaProductoDTO;
import com.grupo2bbva.ecommerce.dtos.CategoriaProductoDTOApplication;
import com.grupo2bbva.ecommerce.models.Categoria;
import com.grupo2bbva.ecommerce.models.Producto;

import java.util.Set;

public interface CategoriaProductoService {
    public boolean add(CategoriaProductoDTOApplication categoriaProductoDTOApplication);
    boolean delete(CategoriaProductoDTOApplication categoriaProductoDTOApplication);


    Set<CategoriaProductoDTO> getAll();
}
