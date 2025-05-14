package com.contacto.contacto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.ProductoImagenModel;

public interface ProductoImagenRepository  extends JpaRepository<ProductoImagenModel, Long> {
    List<ProductoImagenModel> findByIdProducto(Long idProducto);

}
