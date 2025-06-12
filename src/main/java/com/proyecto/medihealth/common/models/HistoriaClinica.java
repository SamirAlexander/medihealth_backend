package com.proyecto.medihealth.common.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "numero_historia")
    private int numeroHistoria;

    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;

    @Column(name = "contacto_emergencia")
    private String contactoEmergencia;

    @Column(name = "telefono_emergencia")
    private int telefonoEmergencia;

    @Column(name = "antecedentes_medicos")
    private String antecedentesMedicos;



    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("historiaClinica")
    private List<RecordMedico> recordsMedicos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente", nullable = false)
    @JsonIgnoreProperties("historiaClinica")
    private Paciente paciente;




    // Constructores, getters y setters
    public HistoriaClinica() {
    }

    public HistoriaClinica( String fechaCreacion, String contactoEmergencia, int telefonoEmergencia, String antecedentesMedicos) {

        this.fechaCreacion = fechaCreacion;
        this.contactoEmergencia = contactoEmergencia;
        this.telefonoEmergencia = telefonoEmergencia;
        this.antecedentesMedicos = antecedentesMedicos;

    }
}
