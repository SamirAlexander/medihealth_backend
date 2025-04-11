package com.proyecto.medihealth.administrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicos")  // Se ajusta el nombre de la tabla a Medicos
@Getter
@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idMedico")
    private int idMedico;  

    @Column(name = "dependencia", nullable = false, length = 100)
    private String dependencia;

    @Column(name = "horarioTrabajo", nullable = false, length = 50)
    private String horarioTrabajo;    

    @Column(name = "numeroLicencia", nullable = true, length = 20)
    private String numeroLicencia;

    @Column(name = "areaEspecializacion", nullable = true, length = 100)
    private String areaEspecializacion;

    @Column(name = "noConsultorio", nullable = true, length = 20)
    private String noConsultorio;
    }



