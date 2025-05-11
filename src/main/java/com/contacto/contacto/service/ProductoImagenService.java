package com.contacto.contacto.service;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.ProductoImagenModel;

import com.contacto.contacto.repository.ProductoImagenRepository;

@Service
public class ProductoImagenService {
    private final ProductoImagenRepository productoImagenRepository;

    public ProductoImagenService(ProductoService productoService, ProductoImagenRepository productoImagenRepository) {        
        this.productoImagenRepository = productoImagenRepository;
    }
    
    //Registrar un producto
    public ProductoImagenModel register(ProductoImagenModel productoImagen) {
        return productoImagenRepository.save(productoImagen);
    }
}
