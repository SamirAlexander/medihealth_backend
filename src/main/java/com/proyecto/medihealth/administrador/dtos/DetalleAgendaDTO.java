package com.proyecto.medihealth.administrador.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class DetalleAgendaDTO {
    private int idDetalleAgenda;
    private Time horaInicio;
    private Time horaFin;
    private String disponibilidad;


}
