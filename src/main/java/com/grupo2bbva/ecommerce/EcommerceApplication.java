package com.grupo2bbva.ecommerce;

import com.grupo2bbva.ecommerce.models.Categoria;
import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.repositories.CategoriaProductoRepository;
import com.grupo2bbva.ecommerce.repositories.CategoriaRepository;
import com.grupo2bbva.ecommerce.repositories.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(CategoriaRepository categoriaRepository, ProductoRepository productoRepository,
									  CategoriaProductoRepository categoriaProductoRepository) {
		return (args) -> {
			// save a couple of customers

			Categoria categoria1 = new Categoria("Alimentos");
			Categoria categoria2 = new Categoria("Bebidas");

			Producto producto1 = new Producto("Fanta 2L", 150L, 22.5);
			Producto producto2 = new Producto("Fideos marolio 500g", 200L,80.1);


		};
	}
}
