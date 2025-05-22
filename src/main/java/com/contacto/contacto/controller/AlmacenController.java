package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.AlmacenModel;
import com.contacto.contacto.service.AlmacenService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/almacen")
public class AlmacenController {
    private final AlmacenService almacenService;
    
    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AlmacenModel>> getAllAlmacenes() {
        return ResponseEntity.ok(almacenService.getAllAlmacenes());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<AlmacenModel> getAlmacenById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(almacenService.getAlmacenById(id));
    }
    
}
