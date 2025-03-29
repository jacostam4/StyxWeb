package com.contacto.contacto.Persitencia.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.Persitencia.model.RolModel;

public interface RolRepository extends JpaRepository<RolModel, Long> {
    Optional<RolModel> findByNombre(String nombre);
}
