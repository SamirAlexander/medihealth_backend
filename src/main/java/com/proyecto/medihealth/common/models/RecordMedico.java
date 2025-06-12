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
    private int id;

    @Column(name = "record_medico", columnDefinition = "TEXT")
    private String recordMedico;

    @Column(name = "fecha_registro", nullable = false)
    private String fechaRegistro;

    @Column(name = "signos_vitales", nullable = false)
    private String signosVitales;

    @Column(name = "motivo_consulta", nullable = false)
    private String motivoConsulta;

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;

    @Column(name = "nombre_medico", nullable = false)
    private String nombreMedico;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_historia", nullable = false)
    @JsonIgnoreProperties("numeroHistoria")
    private HistoriaClinica historiaClinica;

    // Constructores, getters y setters
    public RecordMedico() {}

    public RecordMedico(String recordMedico, String fechaRegistro, HistoriaClinica historiaClinica,
                        String signosVitales, String motivoConsulta, String especialidad, String diagnostico, String nombreMedico)  {
        this.recordMedico = recordMedico;
        this.fechaRegistro = fechaRegistro;
        this.historiaClinica = historiaClinica;
        this.signosVitales = signosVitales;
        this.motivoConsulta = motivoConsulta;
        this.especialidad = especialidad;
        this.diagnostico = diagnostico;
        this.nombreMedico = nombreMedico;
    }
}
