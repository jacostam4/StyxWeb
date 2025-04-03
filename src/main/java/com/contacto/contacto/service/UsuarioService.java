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
        // Guardar la contraseña en texto plano (⚠️ NO recomendado para producción)
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); // Encriptar la contraseña
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> findByCorreo(String email, String rawPassword) {
        return usuarioRepository.findByCorreo(email)
            .filter(usuario -> {
                System.out.println("Contraseña en BD: " + usuario.getContrasena()); // Debug
                System.out.println("Contraseña ingresada: " + rawPassword); // Debug
                boolean match = passwordEncoder.matches(rawPassword, usuario.getContrasena());
                System.out.println("¿Coincide?: " + match);
                return match;
            });
    }
}
