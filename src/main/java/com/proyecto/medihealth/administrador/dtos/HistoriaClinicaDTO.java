package com.proyecto.medihealth.administrador.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HistoriaClinicaDTO {

    private int idHistoriaClinica;

    private int idPaciente;

    @Size(max = 500, message = "El historial médico no puede tener más de 500 caracteres")
    private String fechaCreacion;

    @Size(max = 50, message = "El número de seguro no puede tener más de 50 caracteres")
    private String fechaModificacion;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String informacionMedica;

    private int idUsuario;

}
