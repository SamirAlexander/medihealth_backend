package com.proyecto.medihealth.paciente.repositories;

import com.proyecto.medihealth.common.models.DetalleAgenda;
import com.proyecto.medihealth.paciente.dtos.CitaAsignadaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CitaAsignadaRepository extends JpaRepository< DetalleAgenda, Integer> {

    @Query(value = """
     SELECT 
        a.id_agenda AS idAgenda,
        a.fecha_cita AS fechaCita,
        da.id_detalle_agenda AS idDetalleAgenda,
        da.hora_inicio AS horaInicio,
        da.hora_fin AS horaFin,
        da.disponibilidad AS disponibilidad,
        c.id_consultorio AS idConsultorio,
        c.numero_consultorio AS numeroConsultorio,
        m.id_medico AS idMedico,
        m.especialidad AS especialidad,
        u.nombre AS nombreMedico,
        u.apellido AS apellidoMedico,
        u2.documento_identidad AS documentoIdentidadPaciente,
        p.id_paciente AS idPaciente,
        u2.nombre AS nombrePaciente,
        u2.apellido AS apellidoPaciente
    FROM agendas a
    JOIN detalle_agenda da ON a.id_agenda = da.id_agenda
    JOIN consultorios c ON da.id_consultorio = c.id_consultorio
    JOIN medicos m ON c.id_medico = m.id_medico
    JOIN usuarios u ON m.documento_identidad = u.documento_identidad
    JOIN pacientes p ON da.id_paciente = p.id_paciente
    JOIN usuarios u2 ON p.documento_identidad = u2.documento_identidad
    WHERE p.documento_identidad = :documentoIdentidad
    ORDER BY a.fecha_cita, da.hora_inicio ASC
""", nativeQuery = true)
    List<CitaAsignadaDTO> obtenerCitasPorDocumentoPaciente(@Param("documentoIdentidad") String documentoIdentidad);
}
