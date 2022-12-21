package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.CategoriaDTOApplication;
import com.grupo2bbva.ecommerce.dtos.ProductoDTO;
import com.grupo2bbva.ecommerce.dtos.ProductoDTOApplication;
import com.grupo2bbva.ecommerce.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/products")
    Set<ProductoDTO> getAll(Authentication authentication) {
        if(authentication != null)
            return productoService.getAll();
        else return null;
    }

    @PostMapping("/products")
    ResponseEntity<Object> addProducto(Authentication authentication, @RequestBody ProductoDTOApplication productoDTOApplication) {
        if (authentication != null) {
            if (productoService.create(productoDTOApplication))
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/products")
    ResponseEntity updateProducto(Authentication authentication, @RequestBody ProductoDTOApplication productoDTOApplication) {
        if (authentication != null) {
        if(productoService.update(productoDTOApplication))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/products")
    ResponseEntity deleteProducto(Authentication authentication, @RequestBody ProductoDTOApplication productoDTOApplication) {
        if (authentication != null) {
            if (productoService.delete(productoDTOApplication.getId()))
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }
}
