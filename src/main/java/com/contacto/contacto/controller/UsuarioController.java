package com.contacto.contacto.controller;

import com.contacto.contacto.model.UsuarioModel;
import com.contacto.contacto.service.UsuarioService;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService contactService) {
        this.usuarioService = contactService;
    }

    @PostConstruct
    public void init() {
        System.out.println("🚀 UsuarioController iniciado. Esperando peticiones...");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioModel contact) {
        try {
            UsuarioModel newUser = usuarioService.register(contact);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al registrar usuario: " + e.getMessage());
        }
    }
    
    @PostMapping("/auth")
public ResponseEntity<?> auth(@RequestParam String email, @RequestParam String password) {
    Optional<UsuarioModel> contact = usuarioService.findByCorreo(email, password);
    
    if (contact.isPresent()) {
        return ResponseEntity.ok("{\"message\": \"Authorized\"}");
    } else {
        return ResponseEntity.status(401).body("{\"message\": \"Unauthorized\"}");
    }
}
    
}
