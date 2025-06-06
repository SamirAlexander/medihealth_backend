package com.proyecto.medihealth.medico.repositories;

import com.proyecto.medihealth.common.models.Agenda;
import com.proyecto.medihealth.medico.dtos.AgendaDelDiaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendaDelDiaRepository extends JpaRepository<Agenda, Integer> {

    @Query(value = "SELECT " +
            "a.id_agenda as idAgenda, " +
            "a.fecha_cita as fechaCita, " +
            "a.estado_dia as estadoDia, " +
            "da.id_detalle_agenda as idDetalleAgenda, " +
            "da.hora_inicio as horaInicio, " +
            "da.hora_fin as horaFin, " +
            "da.disponibilidad as disponibilidad, " +
            "c.id_consultorio as idConsultorio, " +
            "c.numero_consultorio as numeroConsultorio, " +
            "m.id_medico as idMedico, " +
            "m.dependencia as dependencia, " +
            "m.horario_trabajo as horarioTrabajo, " +
            "m.numero_licencia as numeroLicencia, " +
            "m.especialidad as especialidad, " +
            "um.documento_identidad as medicoDocumentoIdentidad, " +
            "um.nombre as medicoNombre, " +
            "um.apellido as medicoApellido, " +
            "p.id_paciente as idPaciente, " +
            "up.documento_identidad as pacienteDocumentoIdentidad, " +
            "up.nombre as pacienteNombre, " +
            "up.apellido as pacienteApellido, " +
            "p.historial_medico as historialMedico, " +
            "p.numero_seguro as numeroSeguro, " +
            "p.fecha_nacimiento as fechaNacimiento, " +
            "p.sexo as sexo, " +
            "p.direccion as direccion, " +
            "p.ultima_cita as ultimaCita, " +
            "p.proxima_cita as proximaCita, " +
            "hc.id as idHistoriaClinica, " +
            "hc.numero_historia as numeroHistoria, " +
            "hc.fecha_creacion as fechaCreacionHistoria, " +
            "hc.contacto_emergencia as contactoEmergencia, " +
            "hc.telefono_emergencia as telefonoEmergencia, " +
            "hc.antecedentes_medicos as antecedentesMedicos " +
            "FROM agendas a " +
            "JOIN detalle_agenda da ON a.id_agenda = da.id_agenda " +
            "JOIN consultorios c ON da.id_consultorio = c.id_consultorio " +
            "JOIN medicos m ON c.id_medico = m.id_medico " +
            "JOIN usuarios um ON m.documento_identidad = um.documento_identidad " +
            "LEFT JOIN pacientes p ON da.id_paciente = p.id_paciente " +
            "LEFT JOIN usuarios up ON p.documento_identidad = up.documento_identidad " +
            "LEFT JOIN historia_clinica hc ON p.id_paciente = hc.paciente_id " +
            "WHERE a.fecha_cita = :fecha " +
            "AND c.id_consultorio = :idConsultorio " +
            "ORDER BY da.hora_inicio ASC",
            nativeQuery = true)
    List<AgendaDelDiaDTO> findAgendaDelDiaByConsultorio(
            @Param("fecha") LocalDate fecha,
            @Param("idConsultorio") Integer idConsultorio);
}