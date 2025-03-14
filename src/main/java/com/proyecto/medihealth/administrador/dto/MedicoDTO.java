package com.proyecto.medihealth.administrador.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTO {
    private int idUsuario;
    private String documentoIdentidad;
    private String nombre;
    private String apellido;
    private String teléfono;
    private String correo;
    private String contraseña;
    private String rol;
    private int idMedico;
    private String dependencia;
    private String horarioTrabajo;
    private String numeroLicencia;
    private String areaEspecializacion;
    private String noConsultorio;
}
