package com.proyecto.medihealth.medico.dtos;


import lombok.Getter;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
public class AgendaDelDiaDTO {
    // Datos de Agenda
    private Integer idAgenda;
    private Date fechaCita;
    private String estadoDia;

    // Datos de Detalle Agenda
    private Integer idDetalleAgenda;
    private Date horaInicio;
    private Date horaFin;
    private String disponibilidad;

    // Datos de Consultorio
    private Integer idConsultorio;
    private String numeroConsultorio;

    // Datos de Médico
    private Integer idMedico;
    private String dependencia;
    private String horarioTrabajo;
    private String numeroLicencia;
    private String especialidad;
    private String medicoDocumentoIdentidad;
    private String medicoNombre;
    private String medicoApellido;

    // Datos de Paciente
    private Integer idPaciente;
    private String pacienteDocumentoIdentidad;
    private String pacienteNombre;
    private String pacienteApellido;
    private String historialMedico;
    private String numeroSeguro;
    private Date fechaNacimiento;
    private Character sexo;
    private String direccion;
    private Date ultimaCita;
    private Date proximaCita;

    // Constructor vacío
    public AgendaDelDiaDTO() {
    }

    // Constructor completo
    public AgendaDelDiaDTO(Integer idAgenda, Date fechaCita, String estadoDia,
                           Integer idDetalleAgenda, Date horaInicio, Date horaFin,
                           String disponibilidad, Integer idConsultorio,
                           String numeroConsultorio, Integer idMedico,
                           String dependencia, String horarioTrabajo,
                           String numeroLicencia, String especialidad,
                           String medicoDocumentoIdentidad, String medicoNombre,
                           String medicoApellido, Integer idPaciente,
                           String pacienteDocumentoIdentidad, String pacienteNombre,
                           String pacienteApellido, String historialMedico,
                           String numeroSeguro, Date fechaNacimiento, Character sexo,
                           String direccion, Date ultimaCita, Date proximaCita) {
        this.idAgenda = idAgenda;
        this.fechaCita = fechaCita;
        this.estadoDia = estadoDia;
        this.idDetalleAgenda = idDetalleAgenda;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponibilidad = disponibilidad;
        this.idConsultorio = idConsultorio;
        this.numeroConsultorio = numeroConsultorio;
        this.idMedico = idMedico;
        this.dependencia = dependencia;
        this.horarioTrabajo = horarioTrabajo;
        this.numeroLicencia = numeroLicencia;
        this.especialidad = especialidad;
        this.medicoDocumentoIdentidad = medicoDocumentoIdentidad;
        this.medicoNombre = medicoNombre;
        this.medicoApellido = medicoApellido;
        this.idPaciente = idPaciente;
        this.pacienteDocumentoIdentidad = pacienteDocumentoIdentidad;
        this.pacienteNombre = pacienteNombre;
        this.pacienteApellido = pacienteApellido;
        this.historialMedico = historialMedico;
        this.numeroSeguro = numeroSeguro;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.ultimaCita = ultimaCita;
        this.proximaCita = proximaCita;
    }

  /*  // Métodos adicionales para conversión de tipos si es necesario
    public LocalTime getHoraInicioLocalTime() {
        return horaInicio != null ? horaInicio.toLocalTime() : null;
    }

    public LocalTime getHoraFinLocalTime() {
        return horaFin != null ? horaFin.toLocalTime() : null;
    }*/
}