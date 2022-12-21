package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.CategoriaDTO;
import com.grupo2bbva.ecommerce.dtos.CategoriaDTOApplication;
import com.grupo2bbva.ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categories")
    Set<CategoriaDTO> getAll(Authentication authentication) {
        if (authentication != null) {
            return categoriaService.getAll();
        } else {
            return null;
        }
    }

    @PostMapping("/categories")
    ResponseEntity<Object> addCategoria(Authentication authentication, @RequestBody CategoriaDTOApplication categoriaDTOApplication) {
        if (authentication != null) {
            if (categoriaDTOApplication.getNombre() == null)
                return new ResponseEntity<>("se debe ingresar categoria", HttpStatus.FORBIDDEN);
            if (categoriaService.create(categoriaDTOApplication.getNombre()) != null)
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/categories")
    ResponseEntity<Object> deleteCategoria(Authentication authentication, @RequestBody CategoriaDTOApplication categoriaDTOApplication) {
        if (authentication != null) {
            if(categoriaDTOApplication.getId() == null)
                return new ResponseEntity<>("se debe ingresar todos los datos", HttpStatus.FORBIDDEN);
            if(categoriaService.delete(categoriaDTOApplication.getId()))
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/categories")
    ResponseEntity<Object> updateCategoria(Authentication authentication, @RequestBody CategoriaDTOApplication categoriaDTOApplication) {
        if (authentication != null) {
            if(categoriaDTOApplication.getId() == null || categoriaDTOApplication.getNombre() == null)
                return new ResponseEntity<>("se debe ingresar todos los datos", HttpStatus.FORBIDDEN);
            if (categoriaService.update(categoriaDTOApplication))
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }
}
