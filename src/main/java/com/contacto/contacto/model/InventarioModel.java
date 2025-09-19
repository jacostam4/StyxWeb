package com.contacto.contacto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventario")
@Getter
@Setter
public class InventarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private long idInventario;

    @Column(name = "id_producto", nullable = false)
    private long idProducto;

    @Column(name = "id_almacen", nullable = false)
    private long idAlmacen;

    @Column(name = "id_talla", nullable = false)
    private long idTalla;

    @Column(nullable = false)
    private long cantidad;

    @Column(name = "cantidad_disponible", nullable = false)
    private long cantidadDisponible;

    @Column(name = "cantidad_no_disponible", nullable = false)
    private long cantidadNoDisponible;

    @Column(nullable = false)
    private long reservado;

    @Column(name = "en_bodega", nullable = false)
    private long enBodega;

    @Column(name = "fecha_ultima_movimiento")
    private LocalDateTime fechaUltimaMovimiento;

    @PrePersist
    @PreUpdate
    public void actualizarFechaMovimiento() {
        this.fechaUltimaMovimiento = LocalDateTime.now();
    }
}
