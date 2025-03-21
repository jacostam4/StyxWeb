package com.contacto.contacto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ContactModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String password;

    private Long telefono;

    @Column(nullable = false)
    private String rol;  // 'Admin' o 'Cliente'

    @Column(nullable = false)
    private String tipoDoc; // 'C.C', 'C.E', 'Pasaporte'

    @Column(nullable = false, unique = true)
    private String numeroDoc;

    private String direccion;
}
