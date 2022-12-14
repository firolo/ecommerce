package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CarritoProductoDTO;
import com.grupo2bbva.ecommerce.models.CarritoProducto;
import com.grupo2bbva.ecommerce.repositories.CarritoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarritoProductoServiceImpl implements CarritoProductoService{
    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    @Override
    public List<CarritoProducto> findAll() {
        return carritoProductoRepository.findAll();
    }

    @Override
    public List<CarritoProductoDTO> findAllDTO() {
        return this.findAll().stream().map(CarritoProductoDTO::new).collect(Collectors.toList());
    }

    @Override
    public CarritoProducto findById(Long id) {
        return carritoProductoRepository.findById(id).orElse(null);
    }

    @Override
    public CarritoProductoDTO findByIdDTO(Long id) {
        CarritoProducto carritoProducto = this.findById(id);
        if (carritoProducto != null) {
            return new CarritoProductoDTO(carritoProducto);
        }
        return null;
    }
}
