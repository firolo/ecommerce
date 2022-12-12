package com.grupo2bbva.ecommerce.repositories;

import com.grupo2bbva.ecommerce.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
