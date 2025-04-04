package com.contacto.contacto.service;

import com.contacto.contacto.model.UsuarioModel;
import com.contacto.contacto.repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder(); // Eliminar PasswordEncoder del constructor

    // Eliminar PasswordEncoder del constructor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel register(UsuarioModel usuario) {
        System.out.println("Registrando usuario: " + usuario.getCorreo());        
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); // Encriptar la contraseña
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> findByCorreo(String email) {
        return usuarioRepository.findByCorreo(email);
    }

    public boolean verificarPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
