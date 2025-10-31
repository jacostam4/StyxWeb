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
@Table(name = "producto")
@Getter @Setter
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;

    @Column(name = "id_categoria")
    private long idCategoria;

    private String nombre;
    private float costo;
    private float precio;
    private String referencia;

}
