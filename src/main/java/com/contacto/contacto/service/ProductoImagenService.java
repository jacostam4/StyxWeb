package com.contacto.contacto.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<List<ProductoImagenModel>> getAllProductos() {
        return ResponseEntity.ok(productoImagenRepository.findAll());
    }

    public ResponseEntity<ProductoImagenModel> getProductoById(Long id) {
        return ResponseEntity.ok(productoImagenRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado")));
    }

    public List<ProductoImagenModel> getImagenesPorProducto(Long idProducto) {
        return productoImagenRepository.findByIdProducto(idProducto);
    }

}
