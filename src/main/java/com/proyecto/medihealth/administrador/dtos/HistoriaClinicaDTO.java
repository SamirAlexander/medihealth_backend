package com.proyecto.medihealth.administrador.dtos;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HistoriaClinicaDTO {
    private Long numeroHistoria;
    private String pacienteId;
    private String fechaCreacion;
    private String contactoEmergencia;
    private int telefonoEmergencia;
    private String antecedentesMedicos;
    private List<RecordMedicoDTO> recordsMedicos;

    // Getters y setters
    public Long  getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(Long numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
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
        return recordsMedicos;
    }

    public void setRecordsMedicos(List<RecordMedicoDTO> recordsMedicos) {
        this.recordsMedicos = recordsMedicos;
    }
}
