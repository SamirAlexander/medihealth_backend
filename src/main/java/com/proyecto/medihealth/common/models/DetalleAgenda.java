package com.proyecto.medihealth.common.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "detalleAgenda")
@Getter
@Setter
public class DetalleAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleAgenda", nullable = false)
    private int idDetalleAgenda;

    @Column(name = "horaInicio", nullable = false)
    private Time horaInicio;

    @Column(name = "horaFin", nullable = false)
    private Time horaFin;

    @Column(name = "disponibilidad", nullable = false)
    private String disponibilidad;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgenda", nullable = false, referencedColumnName = "idAgenda")
    @JsonIgnoreProperties("idAgenda")
    private Agenda agendas;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idConsultorio", referencedColumnName = "idConsultorio", nullable = false)
    @JsonIgnoreProperties("consultorio")
    private Consultorios consultorios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @JsonIgnoreProperties("paciente")
    private Paciente paciente;

}
