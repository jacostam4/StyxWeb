package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.ProductoImagenModel;
import com.contacto.contacto.service.ProductoImagenService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin(origins = "*")
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
    
    @GetMapping("/search/{idProducto}")
    public ResponseEntity<List<ProductoImagenModel>> getImagenesPorProducto(@PathVariable Long idProducto) {
        List<ProductoImagenModel> imagenes = productoImagenService.getImagenesPorProducto(idProducto);
        
        // Ajustar las URLs de las imágenes antes de enviarlas
        for (ProductoImagenModel imagen : imagenes) {
            String imageUrl = "http://localhost:8074/Imagenes/" + imagen.getUrlImagen();  // Generar la URL completa
            imagen.setUrlImagen(imageUrl);  // Establecer la URL completa en el modelo
        }
        
        return ResponseEntity.ok(imagenes);
    }
    
    

}
