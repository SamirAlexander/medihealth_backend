package com.proyecto.medihealth.administrador.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministradorDTO {

    // @NotNull(message = "El ID del usuario no puede ser nulo")
    // private int idUsuario; // El ID se puede omitir en el DTO, ya que es auto-generado en la base de datos

    @NotNull(message = "El ID del administrador no puede ser nulo")
    private int idAdmin;

    @NotBlank(message = "El departamento no puede estar vacío")
    private String departamento;

    @NotBlank(message = "El nivel de acceso es obligatorio")
    private String nivelAcceso;

    @NotBlank(message = "El área asignada no puede estar vacía")
    private String areaAsignada;

    @NotBlank(message = "Las tareas asignadas no pueden estar vacías")
    private String tareasAsignadas;

    // Getters y Setters
}
