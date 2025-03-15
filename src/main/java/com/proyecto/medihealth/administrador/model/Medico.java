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
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "documento_identidad", nullable = false, length = 20)
    private String documentoIdentidad;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "contraseña", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;

    @Column(name = "id_medico")
    private int idMedico;  

    @Column(name = "dependencia", nullable = false, length = 100)
    private String dependencia;

    @Column(name = "horario_trabajo", nullable = false, length = 50)
    private String horarioTrabajo;    

    @Column(name = "numero_licencia", nullable = true, length = 20)
    private String numeroLicencia;

    @Column(name = "area_especializacion", nullable = true, length = 100)
    private String areaEspecializacion;

    @Column(name = "no_consultorio", nullable = true, length = 20)
    private String noConsultorio;
    }



