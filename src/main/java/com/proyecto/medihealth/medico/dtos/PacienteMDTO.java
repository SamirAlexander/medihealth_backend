package com.proyecto.medihealth.medico.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteMDTO {
    private Integer idPaciente;
    private String documento_identidad;
    private String nombre;
    private String apellido;

    public PacienteMDTO() {
        // Constructor por defecto
    }
    public PacienteMDTO(Integer idPaciente, String documento_identidad, String nombre, String apellido) {
        this.idPaciente = idPaciente;
        this.documento_identidad = documento_identidad;
        this.nombre = nombre;
        this.apellido = apellido;
    }


}
