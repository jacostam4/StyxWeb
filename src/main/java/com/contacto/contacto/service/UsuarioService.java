package com.contacto.contacto.service;

import com.contacto.contacto.model.UsuarioModel;
import com.contacto.contacto.repository.UsuarioRepository;
import com.contacto.contacto.security.JwtUtil;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder  passwordEncoder;
    private final JwtUtil jwtUtil; 
    
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public UsuarioModel register(UsuarioModel usuario) {
        System.out.println("Registrando usuario: " + usuario.getCorreo());
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); // Encriptar la contraseña
        return usuarioRepository.save(usuario);
    }

    public String authenticate(String email, String password) {
        Optional<UsuarioModel> usuario = usuarioRepository.findByCorreo(email);

        if (usuario.isPresent() && passwordEncoder.matches(password, usuario.get().getContrasena())) {
            return jwtUtil.generateToken(email); // Generar token JWT
        }
        return null;
    }
}
