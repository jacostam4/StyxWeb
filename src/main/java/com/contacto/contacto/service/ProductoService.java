package com.contacto.contacto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contacto.contacto.model.ProductoModel;
import com.contacto.contacto.repository.ProductoRepository;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    //Registrar un producto
    public ProductoModel register(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    //Obtener todos los productos
    public List<ProductoModel> getAllProductos() {
        return productoRepository.findAll();
    }

    //actualizar productos
    public ProductoModel updateProducto (Long id, ProductoModel producto) {
        return productoRepository.findById(id).map(existeProducto -> {
            existeProducto.setNombre(producto.getNombre());
            existeProducto.setPrecio(producto.getPrecio());
            existeProducto.setReferencia(producto.getReferencia());            
            existeProducto.setCosto(producto.getCosto());
            return productoRepository.save(existeProducto);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));   
    }

    public ProductoModel getProductoById(Long id) {
        Optional<ProductoModel> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return producto.get();
        }
        else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
}
