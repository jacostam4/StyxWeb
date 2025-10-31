package com.contacto.contacto.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.ProductoModel;

import java.util.List;
import java.util.Optional;




public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {
    Optional<ProductoModel> findByNombre(String nombre);

    List<ProductoModel> findAllByIdCategoria(long idCategoria);
    
}
