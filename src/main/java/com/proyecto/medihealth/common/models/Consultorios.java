package com.proyecto.medihealth.common.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consultorios")
@Getter
@Setter
public class Consultorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsultorio", nullable = false)
    private int idConsultorio;

    @Column(name = "nombreConsultorio", nullable = false)
    private String numeroConsultorio;
}
