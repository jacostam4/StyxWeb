package com.contacto.contacto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto_imagen")
@Getter @Setter
public class ProductoImagenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long idImagen;
    @Column(name = "id_producto", nullable = false)
    private Long idProducto;
    @Column(name = "url", nullable = false)  
    private String urlImagen;
    @Column(name = "orden")
    private Integer orden;
}
