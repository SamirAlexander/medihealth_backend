package com.proyecto.medihealth.administrador.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeriodoAgendaRequest {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int numeroConsultorios;
    private String horaInicioJornada;
    private String horaFinJornada;
    private int duracionCitaMinutos;
    private String estadoDiaDefault;
}
