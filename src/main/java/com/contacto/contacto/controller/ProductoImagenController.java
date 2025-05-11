package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.ProductoImagenModel;
import com.contacto.contacto.service.ProductoImagenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/producto-imagen")
public class ProductoImagenController {

    private final ProductoImagenService productoImagenService;

    public ProductoImagenController(ProductoImagenService productoImagenService) {
        this.productoImagenService = productoImagenService;
    }


    @PostMapping("/register")
    public ResponseEntity<ProductoImagenModel> register(@RequestBody ProductoImagenModel productoImagen) {
        return ResponseEntity.ok(productoImagenService.register(productoImagen));
    }
    

}
