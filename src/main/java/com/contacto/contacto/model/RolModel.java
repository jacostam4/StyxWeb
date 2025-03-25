package com.contacto.contacto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rol")
@Getter @Setter
public class RolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rol;

    private String nombre;
}
