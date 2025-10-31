package com.contacto.contacto.controller;

import com.contacto.contacto.model.AuthUsuario;
import com.contacto.contacto.model.UsuarioModel;
import com.contacto.contacto.security.JwtUtil;
import com.contacto.contacto.service.UsuarioService;

import io.jsonwebtoken.Claims;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public UsuarioController(UsuarioService contactService, JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
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
        String token = usuarioService.authenticate(authUsuario.getEmail(), authUsuario.getPassword());

        if (token != null) {
            return ResponseEntity.ok("{\"token\": \"" + token + "\"}");
        }

        return ResponseEntity.status(401).body("{\"message\": \"Unauthorized\"}");
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");
            Claims claims = jwtUtil.parseToken(token);

            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("idUsuario", claims.get("idUsuario", Integer.class));
            userInfo.put("nombre", claims.get("nombre", String.class));
            userInfo.put("correo", claims.getSubject()); // correo
            userInfo.put("rol", claims.get("rol", Integer.class)); // o String si usas nombre

            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }
    }

    
    
}
