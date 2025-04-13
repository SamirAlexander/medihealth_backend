package com.proyecto.medihealth.administrador.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HistoriaClinicaDTO {
    private Long numeroHistoria;
    private String pacienteId;
    private String fechaCreacion;
    private List<RecordMedicoDTO> recordsMedicos;

    // Getters y setters
    public Long getNumeroHistoria() {
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

    public List<RecordMedicoDTO> getRecordsMedicos() {
        return recordsMedicos;
    }

    public void setRecordsMedicos(List<RecordMedicoDTO> recordsMedicos) {
        this.recordsMedicos = recordsMedicos;
    }
}
