package com.proyecto.medihealth.paciente.dtos;

import com.proyecto.medihealth.common.models.RecordMedico;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class HistoriaClinicaPaDTO {
    private int idUsuario;
    private String documentoIdentidad;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String rol;

    // Datos del paciente
    private int idPaciente;
    private String historialMedico;
    private String numeroSeguro;
    private Date fechaNacimiento;
    private char sexo;
    private String direccion;
    private Date ultimaCita;
    private Date proximaCita;

    // Datos de historia clínica
    private int hcId;
    private int numeroHistoria;
    private String fechaCreacion;
    private String contactoEmergencia;
    private int telefonoEmergencia;
    private String antecedentesMedicos;

    // Lista de records médicos
    private List<RecordMedico> records;

    public HistoriaClinicaPaDTO() {
    }

    public HistoriaClinicaPaDTO(int idUsuario, String documentoIdentidad, String nombre, String apellido, String telefono,
                                String correo, String rol, int idPaciente, String historialMedico, String numeroSeguro,
                                Date fechaNacimiento, char sexo, String direccion, Date ultimaCita,
                                Date proximaCita, int hcId, int numeroHistoria, String fechaCreacion,
                                String contactoEmergencia, int telefonoEmergencia, String antecedentesMedicos,
                                List<RecordMedico> records) {
        this.idUsuario = idUsuario;
        this.documentoIdentidad = documentoIdentidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.rol = rol;
        this.idPaciente = idPaciente;
        this.historialMedico = historialMedico;
        this.numeroSeguro = numeroSeguro;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.ultimaCita = ultimaCita;
        this.proximaCita = proximaCita;
        this.hcId = hcId;
        this.numeroHistoria = numeroHistoria;
        this.fechaCreacion = fechaCreacion;
        this.contactoEmergencia = contactoEmergencia;
        this.telefonoEmergencia = telefonoEmergencia;
        this.antecedentesMedicos = antecedentesMedicos;
        this.records = records;
    }
}
