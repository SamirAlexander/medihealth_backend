package com.proyecto.medihealth.administrador.dtos;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HistoriaClinicaDTO {
    private Integer numeroHistoria;
    private String fechaCreacion;
    private String contactoEmergencia;
    private int telefonoEmergencia;
    private String antecedentesMedicos;
    private List<RecordMedicoDTO> recordMedico;

    // Getters y setters
    public Integer  getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(Integer numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }


    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getTelefonoEmergencia() { return telefonoEmergencia; }

    public void setTelefonoEmergencia(int telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getAntecedentesMedicos() {
        return antecedentesMedicos;
    }

    public void setAntecedentesMedicos(String antecedentesMedicos) {
        this.antecedentesMedicos = antecedentesMedicos;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public List<RecordMedicoDTO> getRecordsMedicos() {
        return recordMedico;
    }

    public void setRecordMedico(List<RecordMedicoDTO> recordMedico) {
        this.recordMedico = recordMedico;
    }
}
