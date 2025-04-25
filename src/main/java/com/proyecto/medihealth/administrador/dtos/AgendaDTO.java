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

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstadoDia() {
        return estadoDia;
    }

    public void setEstadoDia(String estadoDia) {
        this.estadoDia = estadoDia;
    }
}
