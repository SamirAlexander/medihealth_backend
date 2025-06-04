package com.proyecto.medihealth.medico.dtos;

import com.proyecto.medihealth.common.models.Consultorios;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultorioDTO {
    private Integer idConsultorio;
    private String numeroConsultorio;
    private Integer idMedico;  // Only the medico ID instead of full object

    // All-args constructor
    public ConsultorioDTO(Integer idConsultorio, String numeroConsultorio, Integer idMedico) {
        this.idConsultorio = idConsultorio;
        this.numeroConsultorio = numeroConsultorio;
        this.idMedico = idMedico;
    }

    // No-args constructor
    public ConsultorioDTO() {
    }

    // Conversion method from entity
    public static ConsultorioDTO fromEntity(Consultorios entity) {
        if (entity == null) return null;

        return new ConsultorioDTO(
                entity.getIdConsultorio(),
                entity.getNumeroConsultorio(),
                entity.getMedico() != null ? entity.getMedico().getIdMedico() : null
        );
    }
}
