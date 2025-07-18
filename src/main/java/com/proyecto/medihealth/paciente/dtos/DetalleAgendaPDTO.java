package com.proyecto.medihealth.paciente.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class DetalleAgendaPDTO {
    private Integer idAgenda;
    private Date fechaCita;
    private Integer idDetalleAgenda;
    private Time horaInicio;
    private Time horaFin;
    private String disponibilidad;
    private Integer idConsultorio;
    private String numeroConsultorio;
    private Integer idMedico;
    private String especialidad;
    private String nombreMedico;
    private String apellidoMedico;


    public DetalleAgendaPDTO() {
        // Constructor por defecto
    }
    public DetalleAgendaPDTO(Integer idAgenda, Date fechaCita, Integer idDetalleAgenda, Time horaInicio, Time horaFin,
                             String disponibilidad, Integer idConsultorio, String numeroConsultorio, Integer idMedico,
                             String especialidad, String nombreMedico, String apellidoMedico) {
        this.idAgenda = idAgenda;
        this.fechaCita = fechaCita;
        this.idDetalleAgenda = idDetalleAgenda;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponibilidad = disponibilidad;
        this.idConsultorio = idConsultorio;
        this.numeroConsultorio = numeroConsultorio;
        this.idMedico = idMedico;
        this.especialidad = especialidad;
        this.nombreMedico = nombreMedico;
        this.apellidoMedico = apellidoMedico;
    }







}
