package com.contacto.contacto.controller;

import com.contacto.contacto.model.UsuarioModel;
import com.contacto.contacto.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService contactService) {
        this.usuarioService = contactService;
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioModel> register(@RequestBody UsuarioModel contact) {
        return ResponseEntity.ok(usuarioService.register(contact));
    }
    
    @PostMapping("/auth")
    public ResponseEntity<String> auth(@RequestParam String email, @RequestParam String password) {
        Optional<UsuarioModel> contact = usuarioService.findByCorreo(email, password);
        return contact.isPresent() ? ResponseEntity.ok("Authorized") : ResponseEntity.status(401).body("Unauthorized");
    }
    
}
