package com.contacto.contacto.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.RolModel;

public interface RolRepository extends JpaRepository<RolModel, Long> {
    Optional<RolModel> findByNombre(String nombre);
}
