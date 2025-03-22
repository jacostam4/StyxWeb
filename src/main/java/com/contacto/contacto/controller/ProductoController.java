package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.ProductoModel;
import com.contacto.contacto.service.ProductoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




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
    
}
