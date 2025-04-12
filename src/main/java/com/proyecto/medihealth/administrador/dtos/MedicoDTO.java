package com.proyecto.medihealth.administrador.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTO {

   /*  @NotNull(message = "El ID del usuario no puede ser nulo")
    private int idUsuario; */

    @NotNull(message = "El ID del médico no puede ser nulo")
    private int idMedico;

    @NotBlank(message = "La dependencia no puede estar vacía")
    private String dependencia;

    @NotBlank(message = "El horario de trabajo es obligatorio")
    private String horarioTrabajo;

    @NotBlank(message = "El número de licencia es obligatorio")
    private String numeroLicencia;

    @NotBlank(message = "El área de especialización es obligatoria")
    private String areaEspecializacion;

    @NotBlank(message = "El número de consultorio no puede estar vacío")
    private String noConsultorio;

    // Getters y Setters
}
