package com.proyecto.medihealth.common.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

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
    private long numeroHistoria;

    @Column(name = "paciente_id", nullable = false)
    private String pacienteId;

    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("historiaClinica")
    private List<RecordMedico> recordsMedicos;

    // Constructores, getters y setters
    public HistoriaClinica() {
    }

    public HistoriaClinica(String pacienteId, String fechaCreacion) {
        this.pacienteId = pacienteId;
        this.fechaCreacion = fechaCreacion;
    }
}
