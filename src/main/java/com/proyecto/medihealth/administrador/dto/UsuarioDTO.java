package com.proyecto.medihealth.administrador.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private int idUsuario; // Puedes descomentar si lo necesitas

    @NotBlank(message = "El documento de identidad no puede estar vacío")
    @Size(max = 20, message = "El documento de identidad no puede tener más de 20 caracteres")
    private String documentoIdentidad;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede tener más de 50 caracteres")
    private String apellido;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max = 15, message = "El teléfono no puede tener más de 15 caracteres")
    private String telefono;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe tener un formato válido")
    @Size(max = 100, message = "El correo no puede tener más de 100 caracteres")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 255, message = "La contraseña debe tener entre 8 y 255 caracteres")
    private String contrasena;

    @NotBlank(message = "El rol no puede estar vacío")
    @Size(max = 20, message = "El rol no puede tener más de 20 caracteres")
    private String rol;
}
