package com.grupo2bbva.ecommerce.controllers;

import com.grupo2bbva.ecommerce.dtos.CategoriaProductoDTOApplication;
import com.grupo2bbva.ecommerce.services.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoriaProductoController {
    @Autowired
    CategoriaProductoService categoriaProductoService;

    @PostMapping("/categoryproduct")
    ResponseEntity<Object> joinCategoryProduct(Authentication authentication, @RequestBody CategoriaProductoDTOApplication categoriaProductoDTOApplication) {
        if (authentication != null) {
            if (categoriaProductoService.add(categoriaProductoDTOApplication))
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("categoryproduct")
    ResponseEntity<Object> deleteJoinCategoryProduct(Authentication authentication, @RequestBody CategoriaProductoDTOApplication categoriaProductoDTOApplication) {
        if (authentication != null) {
            if (categoriaProductoService.delete(categoriaProductoDTOApplication))
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>("No se encontró la relación categoría producto", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No estás autenticado", HttpStatus.UNAUTHORIZED);
    }

}
