package com.proyecto.medihealth.administrador.dto;

import java.sql.Date;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

  // private int idUsuario;

  private int idPaciente;

  @Size(max = 500, message = "El historial médico no puede tener más de 500 caracteres")
  private String historialMedico;

  @Size(max = 50, message = "El número de seguro no puede tener más de 50 caracteres")
  private String numeroSeguro;

  @NotNull(message = "La fecha de nacimiento no puede ser nula")
  @Past(message = "La fecha de nacimiento debe ser en el pasado")
  private Date fechaNacimiento;

  private char sexo;

  @NotBlank(message = "La dirección no puede estar vacía")
  @Size(max = 255, message = "La dirección no puede tener más de 255 caracteres")
  private String direccion;

  private Date ultimaCita;
  private Date proximaCita;
}
