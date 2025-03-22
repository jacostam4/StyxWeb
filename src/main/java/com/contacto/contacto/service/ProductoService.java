package com.contacto.contacto.service;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.ProductoModel;
import com.contacto.contacto.repository.ProductoRepository;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ProductoModel register(ProductoModel producto) {
        return productoRepository.save(producto);
    }
}
