package com.proyecto.medihealth.common.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "RecordClinicos")
@Getter
@Setter

public class RecordClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecordClinico", nullable = false)
    private int idRecordClinico;

    @Column(name = "fechaConsulta", nullable = false)
    private Date fechaConsulta;

    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;

    @Column(name = "motivoConsulta", nullable = false)
    private String motivoConsulta;

    @Column(name = "signosVitales", nullable = false)
    private String signosVitales;

    @Column(name = "alergias", nullable = false)
    private String alergias;

    @Column(name = "documentoIdentidadMedico", nullable = false)
    private int documentoIdentidadMedico;

}
