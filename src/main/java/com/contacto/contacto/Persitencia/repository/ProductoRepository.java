package com.contacto.contacto.Persitencia.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.Persitencia.model.ProductoModel;

import java.util.Optional;




public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {
    Optional<ProductoModel> findByNombre(String nombre);
    
}
