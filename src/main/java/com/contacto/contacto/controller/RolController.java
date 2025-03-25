package com.contacto.contacto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.RolModel;
import com.contacto.contacto.service.RolService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("/register")
    public ResponseEntity<RolModel> register(@RequestBody RolModel rol) {
        return ResponseEntity.ok(rolService.register(rol));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RolModel>> getAllRoles() {
        return ResponseEntity.ok(rolService.getAllRoles());
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<RolModel> updateRol(@PathVariable("id") long id,@RequestBody RolModel rol) {
        return ResponseEntity.ok(rolService.updateRol(id, rol));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<RolModel> getRolById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(rolService.getRolById(id));
    }
}
