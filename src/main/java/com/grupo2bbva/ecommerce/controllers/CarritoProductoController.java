package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.services.CarritoProductoService;
import com.grupo2bbva.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarritoProductoController {

    @Autowired
    private CarritoProductoService carritoProductoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/client/carrito/agregar")
    public Producto agregarProductoACarrito(@RequestParam Long idProducto, @RequestParam int cantidadProducto) {
        //Averiguar cliente
        //Producto producto =

        //Cliente.carrito.add

        return null;
    }


}
