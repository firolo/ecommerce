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
import java.util.Set;
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
        boolean productoExisteEnCarrito = false;

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

        List<CarritoProducto> productosExistentes = carrito.getCarritoProductos().stream().collect(Collectors.toList());

        for (CarritoProducto productoExistente : productosExistentes) {
            if (productoExistente.getProducto().getId() == producto.getId()) {
                //Si el producto existe, le agrego la cantidad que ya tiene a la cantidad nueva que me envían
                int cantidadNuevaProductos = productoExistente.getCantidadProductos() + cantidadProductos;
                double precioNuevoProductos = productoExistente.getProducto().getPrecio() * cantidadNuevaProductos;
                double precioNuevoCarrito = carrito.getMontoTotal() + precioNuevoProductos;
                if (cantidadNuevaProductos <= producto.getStock()) {
                    productoExistente.setCantidadProductos(cantidadNuevaProductos);
                    productoExistente.setMonto(precioNuevoProductos);
                    carrito.setMontoTotal(precioNuevoCarrito);

                    carritoRepository.save(carrito);

                    carritoProductoRepository.save(productoExistente);

                    return "Cant. productos modificada";
                }
                return "Cant. productos invalida";
            }
        }

        try {
            CarritoProducto carritoProducto = new CarritoProducto(carrito, producto, cantidadProductos);
            double precioNuevoCarrito = carrito.getMontoTotal() + carritoProducto.getMonto();
            carrito.setMontoTotal(precioNuevoCarrito);

            carritoRepository.save(carrito);

            carritoProductoRepository.save(carritoProducto);
            return "Agregado OK";
        } catch (Exception e) {
            return "No se creo CarritoProducto";
        }
    }

    @Override
    public String quitarProductoDeCarrito(Carrito carrito, Producto producto, int cantidadProductos) {
        if (cantidadProductos < 1) {
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

        List<CarritoProducto> productosExistentes = carrito.getCarritoProductos().stream().collect(Collectors.toList());

        for(CarritoProducto productoExistente : productosExistentes) {
            if (productoExistente.getProducto().getId() == producto.getId()) {
                int cantidadNuevaProductos = productoExistente.getCantidadProductos() - cantidadProductos;
                if (cantidadNuevaProductos < 1) {
                    carrito.setMontoTotal(carrito.getMontoTotal() - productoExistente.getMonto());
                    carritoRepository.save(carrito);
                    carritoProductoRepository.delete(productoExistente);

                    return "Producto eliminado";
                }
                double precioNuevoProductos = productoExistente.getProducto().getPrecio() * cantidadNuevaProductos;
                double precioNuevoCarrito = carrito.getMontoTotal() - productoExistente.getProducto().getPrecio() * cantidadProductos;
                carrito.setMontoTotal(precioNuevoCarrito);

                productoExistente.setMonto(precioNuevoProductos);
                productoExistente.setCantidadProductos(cantidadNuevaProductos);

                carritoRepository.save(carrito);
                carritoProductoRepository.save(productoExistente);

                return "Producto restado";
            }
        }
        return "El carrito no contenía el producto";
    }

    @Override
    public void vaciarCarrito(Cliente cliente) {
        Set<CarritoProducto> carritoProductos = cliente.getCarrito().getCarritoProductos();

        for(CarritoProducto producto : carritoProductos) {
            carritoProductoRepository.delete(producto);
        }

        carritoProductos.clear();
    }
}
