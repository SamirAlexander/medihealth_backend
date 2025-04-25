package com.proyecto.medihealth.common.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "especialidades")
@Getter
@Setter
public class Especialidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidad", nullable = false)
    private int idEspecialidad;

    @Column(name = "nombreEspecialidad", nullable = false)
    private String nombreEspecialidad;
}
