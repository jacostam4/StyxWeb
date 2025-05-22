package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.TallaModel;
import com.contacto.contacto.service.TallaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@CrossOrigin(origins = "*")
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

    @GetMapping("/search/{id}")
    public ResponseEntity<TallaModel> getTallaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(tallaService.getTallaById(id));
    }
    
    
}
