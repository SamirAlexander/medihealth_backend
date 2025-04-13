package com.proyecto.medihealth.common.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "record_medico")
@Getter
@Setter
public class RecordMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "record_medico", columnDefinition = "TEXT")
    private String recordMedico;

    @Column(name = "fecha_registro", nullable = false)
    private String fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_historia", nullable = false)
    @JsonIgnoreProperties("numeroHistoria")
    private HistoriaClinica historiaClinica;

    // Constructores, getters y setters
    public RecordMedico() {}

    public RecordMedico(String recordMedico, String fechaRegistro, HistoriaClinica historiaClinica) {
        this.recordMedico = recordMedico;
        this.fechaRegistro = fechaRegistro;
        this.historiaClinica = historiaClinica;
    }


}
