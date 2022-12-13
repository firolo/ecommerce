package com.grupo2bbva.ecommerce.controllers;


import com.grupo2bbva.ecommerce.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;
}
