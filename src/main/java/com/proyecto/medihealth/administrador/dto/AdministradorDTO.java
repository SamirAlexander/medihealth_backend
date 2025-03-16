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

    @NotBlank(message = "El documento de identidad es obligatorio")
    private String documentoIdentidad;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @Pattern(regexp = "^\\d{10}$", message = "El teléfono debe tener 10 dígitos")
    private String telefono;

    @Email(message = "El correo electrónico no tiene un formato válido")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;

    @NotNull(message = "El ID del administrador no puede ser nulo")
    private int idAdmin;

    @NotBlank(message = "El departamento no puede estar vacío")
    private String departamento;

    @NotBlank(message = "El nivel de acceso es obligatorio")
    private String nivelAcceso;

    @NotNull(message = "El ID del auxiliar de administración no puede ser nulo")
    private int idAuxAdmin;

    @NotBlank(message = "El área asignada no puede estar vacía")
    private String areaAsignada;

    @NotBlank(message = "Las tareas asignadas no pueden estar vacías")
    private String tareasAsignadas;

    // Getters y Setters
}
