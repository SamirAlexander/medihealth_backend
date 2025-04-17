package com.proyecto.medihealth.common.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente", nullable = false)
    private int idPaciente;


    @Column(name = "historialMedico", length = 500)
    private String historialMedico;

    @Column(name = "numeroSeguro", unique = true, length = 50)
    private String numeroSeguro;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "sexo", nullable = false)
    private char sexo;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Temporal(TemporalType.DATE)
    @Column(name = "ultimaCita")
    private Date ultimaCita;

    @Temporal(TemporalType.DATE)
    @Column(name = "proximaCita")
    private Date proximaCita;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("paciente")
    private HistoriaClinica historiaClinica;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentoIdentidad", referencedColumnName = "documentoIdentidad", nullable = false)
    @JsonIgnoreProperties("paciente")
    private Usuario usuario;


}
