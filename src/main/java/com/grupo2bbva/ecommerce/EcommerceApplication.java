package com.grupo2bbva.ecommerce;

import com.grupo2bbva.ecommerce.models.*;
import com.grupo2bbva.ecommerce.repositories.*;
import com.grupo2bbva.ecommerce.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClienteRepository clienteRepository, CarritoRepository carritoRepository,
									  CarritoProductoRepository carritoProductoRepository, TicketRepository ticketRepository,
									  CategoriaRepository categoriaRepository, ProductoRepository productoRepository,
									  CategoriaProductoRepository categoriaProductoRepository) {
		return (args) -> {
			// save a couple of customers
			Cliente cliente1 = new Cliente("Pepito", "Firolo", "pepito@firolo.com", passwordEncoder.encode("123"));
			Cliente cliente2 = new Cliente("admin", "admin", "admin@admin.com", passwordEncoder.encode("123"));

			Carrito carrito1 = new Carrito(cliente1);

			Categoria categoria1 = new Categoria("Alimentos");
			Categoria categoria2 = new Categoria("Bebidas");

			Producto producto1 = new Producto("Fanta 2L", 150L, 22.5);
			Producto producto2 = new Producto("Fideos marolio 500g", 200L,80.1);

			CarritoProducto carritoProducto1 = new CarritoProducto(carrito1, producto1, 5);

			clienteRepository.save(cliente2);
			clienteRepository.save(cliente1);
			carritoRepository.save(carrito1);

			categoriaRepository.save(categoria1);
			categoriaRepository.save(categoria2);

			productoRepository.save(producto1);
			productoRepository.save(producto2);

			carritoProductoRepository.save(carritoProducto1);
		};
	}
	/*
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		emailService.sendEmail("raffi.kocak13@gmail.com", "PRUEBA SUBJECT", "CUERPO EMAIL");
	}
	*/
}
