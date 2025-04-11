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

    @Column(name = "idAdmin", nullable = false)
    private int idAdmin;

    @Column(name = "departamento", nullable = false, length = 100)
    private String departamento;

    @Column(name = "nivelAcceso", nullable = false, length = 50)
    private String nivelAcceso;

    @Column(name = "areaAsignada", length = 100)
    private String areaAsignada;

    @Column(name = "tareasAsignadas", length = 500)
    private String tareasAsignadas;

}
