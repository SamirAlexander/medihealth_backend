package com.proyecto.medihealth.administrador.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordMedicoDTO {
    private String recordMedico;
    private String fechaRegistro;

    // Getters y setters
    public String getRecordMedico() {
        return recordMedico;
    }

    public void setRecordMedico(String recordMedico) {
        this.recordMedico = recordMedico;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
