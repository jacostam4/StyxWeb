package com.contacto.contacto.repository;

import com.contacto.contacto.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByCorreo(String correo);
}
