package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CarritoDTO;
import com.grupo2bbva.ecommerce.dtos.CarritoProductoDTO;
import com.grupo2bbva.ecommerce.models.Carrito;
import com.grupo2bbva.ecommerce.models.CarritoProducto;
import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.repositories.CarritoProductoRepository;
import com.grupo2bbva.ecommerce.repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImpl implements CarritoService{
    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    CarritoProductoRepository carritoProductoRepository;

    @Override
    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    @Override
    public List<CarritoDTO> findAllDTO() {
        return this.findAll().stream().map(CarritoDTO::new).collect(Collectors.toList());
    }

    @Override
    public Carrito findById(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    @Override
    public CarritoDTO findByIdDTO(Long id) {
        Carrito carrito = this.findById(id);

        if (carrito != null) {
            return new CarritoDTO(carrito);
        }

        return null;
    }

    @Override
    public List<CarritoProducto> findProductosByCliente(Cliente cliente) {
        if (cliente != null) {
            return new ArrayList<>(cliente.getCarrito().getCarritoProductos());
        }

        return null;
    }

    @Override
    public List<CarritoProductoDTO> findProductosByClienteDTO(Cliente cliente) {
        if (cliente != null) {
            return cliente.getCarrito().getCarritoProductos().stream().map(CarritoProductoDTO::new).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public String agregarProductoACarrito(Carrito carrito, Producto producto, int cantidadProductos) {
        if (cantidadProductos < 1 || cantidadProductos > producto.getStock()) {
            return "Cant. productos invalida";
        }

        if (!producto.isActive()) {
            return "El producto no esta activo";
        }

        if (producto == null) {
            return "El producto no existe";
        }

        if (carrito == null) {
            return "El carrito no existe";
        }

        CarritoProducto carritoProducto = new CarritoProducto(carrito, producto, cantidadProductos);

        if (carritoProducto != null) {
            carritoProductoRepository.save(carritoProducto);
            return "Agregado OK";
        }

        return "No se creo CarritoProducto";
    }
}
