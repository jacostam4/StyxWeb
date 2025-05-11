package com.contacto.contacto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.ProductoImagenModel;

public interface ProductoImagenRepository  extends JpaRepository<ProductoImagenModel, Long> {
    Optional<ProductoImagenModel> findByIdProducto(Long idProducto);
    Optional<ProductoImagenModel> findByUrlImagen(String urlImagen);
    Optional<ProductoImagenModel> findByOrden(Integer orden);

}
