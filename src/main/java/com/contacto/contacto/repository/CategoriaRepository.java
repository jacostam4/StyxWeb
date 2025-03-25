package com.contacto.contacto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    Optional<CategoriaModel> findByNombre(String nombre);    
}