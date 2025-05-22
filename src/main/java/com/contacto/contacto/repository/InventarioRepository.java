package com.contacto.contacto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacto.contacto.model.InventarioModel;

public interface InventarioRepository extends JpaRepository<InventarioModel, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar inventarios por idProducto o idAlmacen
    List<InventarioModel> findByIdProducto(Long idProducto);
    List<InventarioModel> findByIdAlmacen(Long idAlmacen);
}
