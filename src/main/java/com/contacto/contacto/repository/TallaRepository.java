package com.contacto.contacto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.TallaModel;

public interface TallaRepository extends JpaRepository<TallaModel, Long> {
    Optional<TallaModel> findByNombre(String nombre);
    Optional<TallaModel> findByIdTalla(long idTalla);

}
