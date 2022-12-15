package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.services.CarritoProductoService;
import com.grupo2bbva.ecommerce.services.CarritoService;
import com.grupo2bbva.ecommerce.services.ClienteService;
import com.grupo2bbva.ecommerce.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarritoProductoController {

    @Autowired
    private CarritoProductoService carritoProductoService;

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @PostMapping("/cliente/carrito/agregar")
    public ResponseEntity<Object> agregarProductoACarrito(Authentication authentication, @RequestParam Long idProducto, @RequestParam int cantidadProductos) {
        if (authentication != null) {
            Cliente cliente = clienteService.findByEmail(authentication.getName());

            if (cliente != null) {
                Producto producto = productoService.findById(idProducto);

                if (producto != null) {
                    String respuesta = carritoService.agregarProductoACarrito(cliente.getCarrito(), producto, cantidadProductos);

                    if (respuesta.equals("Agregado OK")) {
                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(respuesta, HttpStatus.FORBIDDEN);
                    }
                }

                // no encontró producto porque estoy de trampa, por ende PROHIBIDO
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.FORBIDDEN);
            }
        }

        // no encontré cliente porque no estoy logueado, por ende no tengo autorización
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/cliente/carrito/quitar")
    public ResponseEntity<Object> quitarProductoDeCarrito(Authentication authentication, @RequestParam Long idProducto, @RequestParam int cantidadProductos) {
        if (authentication != null) {
            Cliente cliente = clienteService.findByEmail(authentication.getName());

            if (cliente != null) {
                Producto producto = productoService.findById(idProducto);

                if (producto != null) {
                    String respuesta = carritoService.quitarProductoDeCarrito(cliente.getCarrito(), producto, cantidadProductos);

                    if (respuesta.equals("Se eliminó el producto del carrito") ||
                            respuesta.equals("Se restó la cantidad del producto en el carrito")) {
                        return new ResponseEntity<>(respuesta, HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(respuesta, HttpStatus.FORBIDDEN);
                    }
                }
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.FORBIDDEN);
            }
        }


        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }
}
