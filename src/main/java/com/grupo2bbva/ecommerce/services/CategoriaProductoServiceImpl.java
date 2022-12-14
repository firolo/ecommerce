package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CategoriaProductoDTOApplication;
import com.grupo2bbva.ecommerce.models.Categoria;
import com.grupo2bbva.ecommerce.models.CategoriaProducto;
import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.repositories.CategoriaProductoRepository;
import com.grupo2bbva.ecommerce.repositories.CategoriaRepository;
import com.grupo2bbva.ecommerce.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {
    @Autowired
    CategoriaProductoRepository categoriaProductoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;

    public boolean add(CategoriaProductoDTOApplication categoriaProductoDTOApplication) {
        Categoria categoria = categoriaRepository.findById(categoriaProductoDTOApplication.getIdcategory()).orElse(null);
        Producto producto = productoRepository.findById(categoriaProductoDTOApplication.getIdproduct()).orElse(null);
        if(categoria != null && producto != null) {
            CategoriaProducto categoriaProducto = new CategoriaProducto(categoria, producto);
            categoriaProductoRepository.save(categoriaProducto);
            return true;
        } else return false;

    }

}
