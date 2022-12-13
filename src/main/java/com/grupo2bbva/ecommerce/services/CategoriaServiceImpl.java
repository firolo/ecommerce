package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CategoriaDTO;
import com.grupo2bbva.ecommerce.models.Categoria;
import com.grupo2bbva.ecommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Override
    public Set<CategoriaDTO> getAll() {
        Set<CategoriaDTO> collect = categoriaRepository.findAll().stream().map(CategoriaDTO::new).collect(Collectors.toSet());
        return collect;
    }

    @Override
    public Categoria create(String nombre) {
        Categoria categoria = new Categoria(nombre);
        categoria.setActive(false);
        categoriaRepository.save(categoria);
        return categoria;
    }

    @Override
    public boolean delete(String nombre) {
        Set<Categoria> categorias = categoriaRepository.findAll().stream().filter(categoria1 -> {return (categoria1.getNombre().equals(nombre));}).collect(Collectors.toSet());
        if(categorias.iterator().hasNext()) {
            Categoria categoria = categorias.iterator().next();
            categoriaRepository.save(categoria);
            return true;
        } else {
            return false;
        }
    }
}
