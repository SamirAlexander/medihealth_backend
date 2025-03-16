package com.proyecto.medihealth.administrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administradores") // Se ajusta el nombre de la tabla a Administrador
@Getter
@Setter
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "documento_identidad", nullable = false, unique = true, length = 20)
    private String documentoIdentidad;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "contraseña", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "rol", nullable = false, length = 20)
    private String rol;

    @Column(name = "idAdmin", nullable = false)
    private int idAdmin;

    @Column(name = "departamento", nullable = false, length = 100)
    private String departamento;

    @Column(name = "nivelAcceso", nullable = false, length = 50)
    private String nivelAcceso;

    @Column(name = "idAuxAdmin", nullable = false)
    private int idAuxAdmin;

    @Column(name = "areaAsignada", length = 100)
    private String areaAsignada;

    @Column(name = "tareasAsignadas", length = 500)
    private String tareasAsignadas;
}
