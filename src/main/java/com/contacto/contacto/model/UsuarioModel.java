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
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "id_rol", nullable = false)
    private Long idRol;

    @Column(name = "tipo_doc", nullable = false)
    private String tipoDoc;

    @Column(name = "numero_doc", nullable = false, unique = true)
    private String numeroDoc;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;
}
