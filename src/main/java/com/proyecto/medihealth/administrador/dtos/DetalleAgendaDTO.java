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
    private String consultorio;
    private String medico;
    private String especialidad;

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getIdDetalleAgenda() {
        return idDetalleAgenda;
    }

    public void setIdDetalleAgenda(int idDetalleAgenda) {
        this.idDetalleAgenda = idDetalleAgenda;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
