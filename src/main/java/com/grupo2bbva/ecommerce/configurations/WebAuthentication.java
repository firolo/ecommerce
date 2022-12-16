package com.grupo2bbva.ecommerce.configurations;

import com.grupo2bbva.ecommerce.models.Cliente;
import com.grupo2bbva.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputMail -> {
            Cliente cliente = clienteRepository.findByEmail(inputMail);

            if (cliente != null) {
//                if (cliente.getEmail().contains("@mindhub.com")) {
//                    return new User(cliente.getEmail(), cliente.getPassword(),
//                            AuthorityUtils.createAuthorityList("ADMIN"));
//                }

                return new User(cliente.getEmail(), cliente.getPassword(),
                        AuthorityUtils.createAuthorityList("USER"));
            } else {
                throw new UsernameNotFoundException("Unknown user: " + inputMail);
            }
        }); //fin userDetailsService
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }*/
}
