package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.TallaModel;
import com.contacto.contacto.service.TallaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/talla")
public class TallaController {

    private final TallaService tallaService;
    
    public TallaController(TallaService tallaService) {
        this.tallaService = tallaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TallaModel>> getAllTallas() {
        return ResponseEntity.ok(tallaService.getAllTallas());
    }
    
}
