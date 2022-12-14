package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.CategoriaDTO;
import com.grupo2bbva.ecommerce.dtos.CategoriaDTOApplication;
import com.grupo2bbva.ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categories")
    Set<CategoriaDTO> getAll() {
        return categoriaService.getAll();
    }

    @PostMapping("/categories")
    ResponseEntity<Object> addCategoria(@RequestBody CategoriaDTOApplication categoriaDTOApplication) {
        if(categoriaService.create(categoriaDTOApplication.getNombre()) != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/categories")
    ResponseEntity<Object> deleteCategoria(@RequestBody CategoriaDTOApplication categoriaDTOApplication) {
        if(categoriaService.delete(categoriaDTOApplication.getId()))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/categories")
    ResponseEntity<Object> updateCategoria(@RequestBody CategoriaDTOApplication categoriaDTOApplication) {
        if(categoriaService.update(categoriaDTOApplication))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
