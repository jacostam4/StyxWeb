package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.CategoriaModel;
import com.contacto.contacto.model.ProductoModel;
import com.contacto.contacto.service.CategoriaService;
import com.contacto.contacto.service.ProductoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {


    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/register")
    public ResponseEntity<CategoriaModel> register(@RequestBody CategoriaModel categoria) {
        return ResponseEntity.ok(categoriaService.register(categoria));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoriaModel>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoriaModel> updateCategoria(@PathVariable("id") long id,@RequestBody CategoriaModel categoria) {
        return ResponseEntity.ok(categoriaService.updateCategoria(id, categoria));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<CategoriaModel> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }
}
