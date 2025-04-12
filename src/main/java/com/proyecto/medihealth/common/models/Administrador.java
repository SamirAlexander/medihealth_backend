package com.proyecto.medihealth.common.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentoIdentidad", referencedColumnName = "documentoIdentidad", nullable = false)
    @JsonIgnoreProperties("administrador")
    private Usuario usuario;

}
