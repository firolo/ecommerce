package com.grupo2bbva.ecommerce;


import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.repositories.ClienteRepository;
import com.grupo2bbva.ecommerce.repositories.ProductoRepository;
import com.grupo2bbva.ecommerce.services.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TicketTests {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    TicketService ticketService;
    @Autowired
    ProductoRepository productoRepository;
    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    public void compraOKTest() {
        Cliente cliente = clienteRepository.findById(Long.valueOf(1)).orElse(null);
        Producto producto = productoRepository.findById(Long.valueOf(1)).orElse(null);
        producto.setStock(1L);
        String resultado = ticketService.comprar(cliente);
        assertThat(resultado,is(not(emptyOrNullString())));
    }
}
