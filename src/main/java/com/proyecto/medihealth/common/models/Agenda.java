package com.proyecto.medihealth.common.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

//JPA es la tecnología de persistencia de Java que permite mapear objetos Java a tablas de bases de datos relacionales.
//
@Entity
@Table(name = "agendas")
@Getter
@Setter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgenda", nullable = false)
    private int idAgenda;

    @Column(name = "fechaCita", nullable = false)
    private Date fechaCita;

    @Column(name = "estadoDia", nullable = false)
    private String estadoDia;

    @OneToMany(mappedBy = "agendas", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("agendas")
    private List<DetalleAgenda> detalleAgenda;



}
