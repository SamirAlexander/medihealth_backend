package com.proyecto.medihealth.common.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "historiasClinicas")
@Getter
@Setter
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistoriaClinica", nullable = false)
    private int idHistoriaClinica;

    @Column(name= "numeroHistoriaClinica", nullable = false)
    private long numeroHistoriaClinica;

    @Column(name = "documentoIdentidadPaciente", nullable = false)
    private int documentoIdentidadPaciente;

    @Column(name = "fechaCreacion", nullable = false)
    private String fechaCreacion;

    @Column(name = "fechaModificacion", nullable = false)
    private String informacionMedica;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordClinico> record = new ArrayList<>();
}
