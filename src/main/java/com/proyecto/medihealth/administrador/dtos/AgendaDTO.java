package com.proyecto.medihealth.administrador.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AgendaDTO {
    private int idAgenda;
    private Date fechaCita;
    private String estadoDia;

}
