package com.proyecto.medihealth.medico.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultorioDTO {
    private Integer idConsultorio;
    private String numeroConsultorio;

    // Constructor, getters y setters
    public ConsultorioDTO(Integer idConsultorio, String numeroConsultorio) {
        this.idConsultorio = idConsultorio;
        this.numeroConsultorio = numeroConsultorio;
    }

}
