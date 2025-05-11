package com.contacto.contacto.service;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.ProductoImagenModel;

import com.contacto.contacto.repository.ProductoImagenRepository;

@Service
public class ProductoImagenService {
    private final ProductoService productoService;
    private final ProductoImagenRepository productoImagenRepository;

    public ProductoImagenService(ProductoService productoService, ProductoImagenRepository productoImagenRepository) {
        this.productoService = productoService;
        this.productoImagenRepository = null;
    }
    
    //Registrar un producto
    public ProductoImagenModel register(ProductoImagenModel productoImagen) {
        return productoImagenRepository.save(productoImagen);
    }
}
