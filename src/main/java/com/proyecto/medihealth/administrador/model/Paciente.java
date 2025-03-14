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
    private int idUsuario;
    
    @Column(name = "documento_identidad", nullable = false, unique = true)
    private String documentoIdentidad;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellido;
    
    @Column(nullable = false)
    private String teléfono;
    
    @Column(nullable = false, unique = true)
    private String correo;
    
    @Column(nullable = false)
    private String contraseña;
    
    @Column(nullable = false)
    private String rol;
    
    @Column(nullable = false)
    private int idPaciente;
    
    @Column(name = "historial_medico")
    private String historialMedico;
    
    @Column(name = "numero_seguro", unique = true)
    private String numeroSeguro;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    
    @Column(nullable = false)
    private char sexo;
    
    @Column(nullable = false)
    private String dirección;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "ultima_cita")
    private Date ultimaCita;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "proxima_cita")
    private Date proximaCita;
}