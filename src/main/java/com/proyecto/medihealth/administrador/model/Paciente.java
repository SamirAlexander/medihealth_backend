package com.proyecto.medihealth.administrador.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
}
