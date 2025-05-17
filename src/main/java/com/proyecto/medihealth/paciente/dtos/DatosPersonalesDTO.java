package com.proyecto.medihealth.paciente.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class    DatosPersonalesDTO {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String sexo;
    private String telefono;
    private String direccion;
    private String correo;

    public DatosPersonalesDTO(String nombre, String apellido, String fechaNacimiento, String sexo, String telefono, String direccion, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }


}
