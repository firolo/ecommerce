package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.CategoriaDTOApplication;
import com.grupo2bbva.ecommerce.dtos.ProductoDTO;
import com.grupo2bbva.ecommerce.dtos.ProductoDTOApplication;
import com.grupo2bbva.ecommerce.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/products")
    Set<ProductoDTO> getAll() {
        return productoService.getAll();
    }

    @PostMapping("/products")
    ResponseEntity<Object> addProducto(@RequestBody ProductoDTOApplication productoDTOApplication) {
        if(productoService.create(productoDTOApplication))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/products")
    ResponseEntity updateProducto(@RequestBody ProductoDTOApplication productoDTOApplication) {
        if(productoService.update(productoDTOApplication))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/products")
    ResponseEntity deleteProducto(@RequestBody ProductoDTOApplication productoDTOApplication) {
        if(productoService.delete(productoDTOApplication.getId()))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
