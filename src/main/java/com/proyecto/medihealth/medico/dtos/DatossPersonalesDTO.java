package com.proyecto.medihealth.medico.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatossPersonalesDTO {

    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public DatossPersonalesDTO(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }
}
