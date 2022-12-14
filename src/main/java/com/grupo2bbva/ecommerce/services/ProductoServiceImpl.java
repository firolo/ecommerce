package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.ProductoDTO;
import com.grupo2bbva.ecommerce.dtos.ProductoDTOApplication;
import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Override
    public Set<ProductoDTO> getAll() {
        return productoRepository.findAll().stream().map(ProductoDTO::new).collect(Collectors.toSet());
    }

    @Override
    public boolean create(ProductoDTOApplication productoDTOApplication) {
        Producto producto = new Producto(productoDTOApplication.getNombre(), productoDTOApplication.getStock(), productoDTOApplication.getPrecio());
        productoRepository.save(producto);
        return true;
    }

    @Override
    public boolean update(ProductoDTOApplication productoDTOApplication) {
        Producto producto = productoRepository.findById(productoDTOApplication.getId()).orElse(null);
        if(producto != null) {
            producto.setNombre(productoDTOApplication.getNombre());
            producto.setPrecio(productoDTOApplication.getPrecio());
            producto.setStock(productoDTOApplication.getStock());
            productoRepository.save(producto);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if(producto != null) {
            producto.setActive(false);
            productoRepository.save(producto);
            return true;
        }
        return false;
    }
}
