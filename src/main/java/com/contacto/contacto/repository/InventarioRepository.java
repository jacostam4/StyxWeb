package com.contacto.contacto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.contacto.contacto.model.InventarioModel;

public interface InventarioRepository extends JpaRepository<InventarioModel, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar inventarios por idProducto o idAlmacen
    List<InventarioModel> findByIdProducto(Long idProducto);
    List<InventarioModel> findByIdAlmacen(Long idAlmacen);

     // 🔎 Búsqueda por producto (req), talla (opt), categoría (opt)
    @Query(value = """
    SELECT i.* 
    FROM inventario i
    JOIN producto p ON p.id_producto = i.id_producto
    WHERE (:productoId IS NULL OR i.id_producto = :productoId)
      AND (:tallaId IS NULL OR i.id_talla = :tallaId)
      AND (:categoriaId IS NULL OR p.id_categoria = :categoriaId)
    """, nativeQuery = true)
      List<InventarioModel> buscarPorFiltros(
              @Param("productoId") Long productoId,
              @Param("tallaId") Long tallaId,
              @Param("categoriaId") Long categoriaId
      );

}
