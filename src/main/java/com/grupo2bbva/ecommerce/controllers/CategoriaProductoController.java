package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.CategoriaProductoDTOApplication;
import com.grupo2bbva.ecommerce.services.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoriaProductoController {
    @Autowired
    CategoriaProductoService categoriaProductoService;

    @PostMapping("/categoryproduct")
    ResponseEntity<Object> joinCategoryProduct(@RequestBody CategoriaProductoDTOApplication categoriaProductoDTOApplication) {
        if(categoriaProductoService.add(categoriaProductoDTOApplication))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
