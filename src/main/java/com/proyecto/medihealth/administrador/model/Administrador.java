package com.proyecto.medihealth.administrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Administrador")  // Se ajusta el nombre de la tabla a Administrador
@Getter
@Setter
public class Administrador {

    @Id
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "documento_identidad")
    private String documentoIdentidad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "rol")
    private String rol;

    @Column(name = "idAdmin")
    private int idAdmin;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "nivelAcceso")
    private String nivelAcceso;

    @Column(name = "idAuxAdmin")
    private int idAuxAdmin;

    @Column(name = "areaAsignada")
    private String areaAsignada;

    @Column(name = "tareasAsignadas")
    private String tareasAsignadas;    
}