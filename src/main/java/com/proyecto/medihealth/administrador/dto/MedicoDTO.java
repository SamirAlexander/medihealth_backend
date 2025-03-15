package com.proyecto.medihealth.administrador.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTO {

   /*  @NotNull(message = "El ID del usuario no puede ser nulo")
    private int idUsuario; */

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
