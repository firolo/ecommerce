package com.grupo2bbva.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class EcommerceApplicationTests {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Test
	void contextLoads() {
	}

}
