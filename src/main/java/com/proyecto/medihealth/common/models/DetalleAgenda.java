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

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "disponibilidad", nullable = false)
    private String disponibilidad;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgenda", nullable = false, referencedColumnName = "idAgenda")
    @JsonIgnoreProperties("idAgenda")
    private Agenda agendas;


    @OneToOne(mappedBy = "consultorios")
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id_consultorio", nullable = false)
    @JsonIgnoreProperties("consultorios")
    private Consultorios consultorios;

}
