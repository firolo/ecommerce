package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CarritoDTO;
import com.grupo2bbva.ecommerce.dtos.CarritoProductoDTO;
import com.grupo2bbva.ecommerce.models.Carrito;
import com.grupo2bbva.ecommerce.models.CarritoProducto;
import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.models.Producto;

import java.util.List;

public interface CarritoService {
    List<Carrito> findAll();

    List<CarritoDTO> findAllDTO();

    Carrito findById(Long id);

    CarritoDTO findByIdDTO(Long id);

    List<CarritoProducto> findProductosByCliente(Cliente cliente);

    List<CarritoProductoDTO> findProductosByClienteDTO(Cliente cliente);

    String agregarProductoACarrito(Carrito carrito, Producto producto, int cantidadProductos);

    String quitarProductoDeCarrito(Carrito carrito, Producto producto, int cantidadProductos);

    void vaciarCarrito(Cliente cliente);
}
