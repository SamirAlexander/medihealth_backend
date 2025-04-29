package com.proyecto.medihealth.administrador.data;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PeriodoAgendaResponse {
    private String status;
    private String message;
    private int totalAgendasCreadas;
    private int totalDetallesCreados;
    private List<LocalDate> fechasGeneradas;

    public PeriodoAgendaResponse(String status, String message, int totalAgendasCreadas,
                                 int totalDetallesCreados, List<LocalDate> fechasGeneradas) {
        this.status = status;
        this.message = message;
        this.totalAgendasCreadas = totalAgendasCreadas;
        this.totalDetallesCreados = totalDetallesCreados;
        this.fechasGeneradas = fechasGeneradas;
    }

}
