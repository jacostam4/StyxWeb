package com.contacto.contacto.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.contacto.contacto.model.InventarioModel;
import com.contacto.contacto.repository.InventarioRepository;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    // Registrar inventario
    public InventarioModel register(InventarioModel inventario) {
        return inventarioRepository.save(inventario);
    }

    // Obtener todos los inventarios
    public List<InventarioModel> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    // Obtener inventario por ID
    public InventarioModel getInventarioById(Long id) {
        return inventarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    // Obtener inventarios por idProducto
    public List<InventarioModel> getInventariosByIdProducto(Long idProducto) {
        return inventarioRepository.findByIdProducto(idProducto);
    }

    // Obtener inventarios por idAlmacen
    public List<InventarioModel> getInventariosByIdAlmacen(Long idAlmacen) {
        return inventarioRepository.findByIdAlmacen(idAlmacen);
    }

    // Actualizar inventario
    public InventarioModel updateInventario(Long id, InventarioModel inventario) {
        return inventarioRepository.findById(id).map(existeInventario -> {
            existeInventario.setIdProducto(inventario.getIdProducto());
            existeInventario.setIdAlmacen(inventario.getIdAlmacen());
            existeInventario.setCantidad(inventario.getCantidad());
            existeInventario.setCantidadDisponible(inventario.getCantidadDisponible());
            existeInventario.setCantidadNoDisponible(inventario.getCantidadNoDisponible());
            existeInventario.setReservado(inventario.getReservado());
            existeInventario.setEnBodega(inventario.getEnBodega());
            return inventarioRepository.save(existeInventario);
        }).orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    // Eliminar inventario
    public void deleteInventario(Long id) {
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Inventario no encontrado");
        }
    }

    public List<InventarioModel> buscar(Long productoId, Long tallaId, Long categoriaId) {
        return inventarioRepository.buscarPorFiltros(productoId, tallaId, categoriaId);
    }

}
