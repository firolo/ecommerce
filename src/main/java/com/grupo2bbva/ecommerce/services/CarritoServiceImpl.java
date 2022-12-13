package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CarritoDTO;
import com.grupo2bbva.ecommerce.models.Carrito;
import com.grupo2bbva.ecommerce.repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CarritoServiceImpl implements CarritoService{
    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    @Override
    public List<CarritoDTO> findAllDTO() {
        return this.findAll().stream().map(CarritoDTO::new).collect(Collectors.toList());
    }

    @Override
    public Carrito findById(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    @Override
    public CarritoDTO findByIdDTO(Long id) {
        Carrito carrito = this.findById(id);

        if (carrito != null) {
            return new CarritoDTO(carrito);
        }

        return null;
    }
}
