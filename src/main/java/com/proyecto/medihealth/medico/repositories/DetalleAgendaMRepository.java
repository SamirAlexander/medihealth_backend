package com.proyecto.medihealth.medico.repositories;

import com.proyecto.medihealth.common.models.DetalleAgenda;
import com.proyecto.medihealth.medico.dtos.DetalleAgendaMDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DetalleAgendaMRepository extends JpaRepository<DetalleAgenda, Integer> {

    @Query(value = """
    SELECT 
        a.id_agenda as idAgenda,
        a.fecha_cita as fechaCita,
        da.id_detalle_agenda as idDetalleAgenda,
        da.hora_inicio as horaInicio,
        da.hora_fin as horaFin,
        da.disponibilidad as disponibilidad,
        c.id_consultorio as idConsultorio,
        c.numero_consultorio as numeroConsultorio,
        m.id_medico as idMedico,
        m.especialidad as especialidad,
        um.nombre as nombreMedico,
        um.apellido as apellidoMedico        
    FROM agendas a
    JOIN detalle_agenda da ON a.id_agenda = da.id_agenda
    JOIN consultorios c ON da.id_consultorio = c.id_consultorio
    JOIN medicos m ON c.id_medico = m.id_medico
    JOIN usuarios um ON m.documento_identidad = um.documento_identidad               
    WHERE a.fecha_cita = :fecha
      AND c.id_consultorio = :idConsultorio
      AND da.disponibilidad = 'Disponible'
    ORDER BY da.hora_inicio ASC
""", nativeQuery = true)
    List<DetalleAgendaMDTO> findHorariosDisponiblesPaciente(
            @Param("fecha") Date fecha,
            @Param("idConsultorio") Integer idConsultorio

    );
}
