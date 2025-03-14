package com.proyecto.medihealth.administrador.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
  private int idUsuario;
  private String documentoIdentidad;
  private String nombre;
  private String apellido;
  private String teléfono;
  private String correo;
  private String contraseña;
  private String rol;
  private int idPaciente;
  private String historialMedico;
  private String numeroSeguro;
  private Date fechaNacimiento;
  private char sexo;
  private String dirección;
  private Date ultimaCita;
  private Date proximaCita;

}
