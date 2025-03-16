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
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;

    @Column(name = "documento_identidad", nullable = false, unique = true, length = 20)
    private String documentoIdentidad;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "contraseña", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "rol", nullable = false, length = 20)
    private String rol;

    @Column(name = "id_paciente", nullable = false)
    private int idPaciente;

    @Column(name = "historial_medico", length = 500)
    private String historialMedico;

    @Column(name = "numero_seguro", unique = true, length = 50)
    private String numeroSeguro;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "sexo", nullable = false)
    private char sexo;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Temporal(TemporalType.DATE)
    @Column(name = "ultima_cita")
    private Date ultimaCita;

    @Temporal(TemporalType.DATE)
    @Column(name = "proxima_cita")
    private Date proximaCita;
}
