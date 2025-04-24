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

    @Column(name = "consultorio", nullable = false)
    private String consultorio;

    @Column(name = "medico", nullable = false)
    private String medico;

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgenda", nullable = false, referencedColumnName = "idAgenda")
    @JsonIgnoreProperties("idAgenda")
    private Agenda agendas;
}
