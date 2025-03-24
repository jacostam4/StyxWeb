package com.contacto.contacto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter @Setter
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

    private String nombre;
    private String correo;
    private String telefono;

    

    @Column(nullable = false)
    private Long id_rol;  // 'Admin' o 'Cliente'

    @Column(nullable = false)
    private String tipo_doc; // 'C.C', 'C.E', 'Pasaporte'

    @Column(nullable = false, unique = true)
    private String numero_doc;

    private String direccion;
    private String contrasena;
}
