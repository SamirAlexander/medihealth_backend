package com.proyecto.medihealth.paciente.repositories;


import com.proyecto.medihealth.common.models.DetalleAgenda;
import com.proyecto.medihealth.paciente.dtos.DetalleAgendaPDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DetalleAgendaPRepository extends JpaRepository<DetalleAgenda, Integer> {


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
    List<DetalleAgendaPDTO> findHorariosDisponiblesPaciente(
            @Param("fecha") Date fecha,
            @Param("idConsultorio") Integer idConsultorio

    );
    // NUEVO MÉTODO para obtener la cita actual de un paciente
    @Query("SELECT da FROM DetalleAgenda da WHERE da.paciente.idPaciente = :idPaciente AND da.disponibilidad = 'Ocupado' ORDER BY da.horaInicio DESC")
    List<DetalleAgenda> findAllByPacienteIdAndDisponibilidadIgnoreCase(Integer idPaciente, String disponibilidad);



}
