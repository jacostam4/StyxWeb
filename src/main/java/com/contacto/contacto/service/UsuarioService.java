package com.contacto.contacto.service;

import com.contacto.contacto.model.UsuarioModel;
import com.contacto.contacto.repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    // Eliminar PasswordEncoder del constructor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel register(UsuarioModel usuario) {
        // Guardar la contraseña en texto plano (⚠️ NO recomendado para producción)
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> findByCorreo(String email, String rawPassword) {
        return usuarioRepository.findByCorreo(email)
            .filter(usuario -> usuario.getContrasena().equals(rawPassword)); // Comparación directa (No seguro)
    }
}
