package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.ProductoModel;
import com.contacto.contacto.service.ProductoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/register")
    public ResponseEntity<ProductoModel> register(@RequestBody ProductoModel producto) {
        return ResponseEntity.ok(productoService.register(producto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductoModel>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductoModel> updateProducto(@PathVariable("id") long id,@RequestBody ProductoModel producto) {
        return ResponseEntity.ok(productoService.updateProducto(id, producto));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ProductoModel> getProductoById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productoService.getProductoById(id));
    }
    
}
