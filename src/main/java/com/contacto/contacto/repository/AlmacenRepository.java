package com.contacto.contacto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.AlmacenModel;

public interface AlmacenRepository  extends JpaRepository<AlmacenModel, Long> {
    Optional<AlmacenModel> findByNombre(String nombre);
    Optional<AlmacenModel> findByIdAlmacen(long idAlmacen);

}
