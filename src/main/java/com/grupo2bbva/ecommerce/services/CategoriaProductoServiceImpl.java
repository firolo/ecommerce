package com.grupo2bbva.ecommerce.services;

import com.grupo2bbva.ecommerce.dtos.CategoriaProductoDTO;
import com.grupo2bbva.ecommerce.dtos.CategoriaProductoDTOApplication;
import com.grupo2bbva.ecommerce.models.Categoria;
import com.grupo2bbva.ecommerce.models.CategoriaProducto;
import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.repositories.CategoriaProductoRepository;
import com.grupo2bbva.ecommerce.repositories.CategoriaRepository;
import com.grupo2bbva.ecommerce.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {
    @Autowired
    CategoriaProductoRepository categoriaProductoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;

    public boolean add(CategoriaProductoDTOApplication categoriaProductoDTOApplication) {
        Categoria categoria = categoriaRepository.findById(categoriaProductoDTOApplication.getIdcategory()).orElse(null);
        Producto producto = productoRepository.findById(categoriaProductoDTOApplication.getIdproduct()).orElse(null);
        if(categoria != null && producto != null) {
            CategoriaProducto categoriaProducto = new CategoriaProducto(categoria, producto);
            categoriaProductoRepository.save(categoriaProducto);
            return true;
        } else return false;

    }

    @Override
    public boolean delete(CategoriaProductoDTOApplication categoriaProductoDTOApplication) {
        List<CategoriaProducto> categoriaProductos = categoriaProductoRepository.findAll();
        List<CategoriaProducto>  categoriaProductoFiltrado = categoriaProductos.stream().
                filter(categoriaProducto1 ->
                { if (categoriaProducto1.getProducto().getId() == categoriaProductoDTOApplication.getIdproduct() &&
                categoriaProducto1.getCategoria().getId() == categoriaProductoDTOApplication.getIdcategory()) return true; return false;}).
                collect(Collectors.toList());

        if(categoriaProductoFiltrado.iterator().hasNext()) {
            categoriaProductoRepository.delete(categoriaProductos.iterator().next());
            return true;
        }
        return false;
    }

    @Override
    public Set<CategoriaProductoDTO> getAll() {
        return categoriaProductoRepository.findAll().stream().map(CategoriaProductoDTO::new).collect(Collectors.toSet());
    }

}
