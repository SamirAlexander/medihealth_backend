package com.proyecto.medihealth.administrador.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordMedicoDTO {
    private String recordMedico;
    private String fechaRegistro;
    private String signosVitales;
    private String motivoConsulta;
    private String especialidad;
    private String diagnostico;
    private String nombreMedico;

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


    public String getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(String signosVitales) {
        this.signosVitales = signosVitales;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
}
