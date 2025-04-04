package com.contacto.contacto.controller;

import com.contacto.contacto.model.AuthUsuario;
import com.contacto.contacto.model.UsuarioModel;
import com.contacto.contacto.service.UsuarioService;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
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
    public ResponseEntity<?> auth(@RequestBody AuthUsuario authUsuario) {
        Optional<UsuarioModel> usuario = usuarioService.findByCorreo(authUsuario.getEmail());

        if (usuario.isPresent()) {
            System.out.println("🔍 Usuario encontrado: " + usuario.get().getCorreo());

            if (usuarioService.verificarPassword(authUsuario.getPassword(), usuario.get().getContrasena())) {
                System.out.println("🔐 Contraseña correcta");
                return ResponseEntity.ok("{\"message\": \"Authorized\"}");
            } else {
                System.out.println("❌ Contraseña incorrecta");
            }
        } else {
            System.out.println("🚨 Usuario no encontrado");
        }

        return ResponseEntity.status(401).body("{\"message\": \"Unauthorized\"}");
    }
    
}
