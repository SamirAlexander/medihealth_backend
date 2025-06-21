package com.proyecto.medihealth.paciente.services;

import com.proyecto.medihealth.administrador.dtos.DetalleAgendaDTO;
import com.proyecto.medihealth.administrador.repositories.AgendaRepository;
import com.proyecto.medihealth.administrador.repositories.PacienteRepository;
import com.proyecto.medihealth.common.models.Agenda;
import com.proyecto.medihealth.common.models.DetalleAgenda;
import com.proyecto.medihealth.common.models.Paciente;
import com.proyecto.medihealth.medico.dtos.AgendaDelDiaDTO;
import com.proyecto.medihealth.paciente.dtos.DetalleAgendaPDTO;
import com.proyecto.medihealth.paciente.repositories.DetalleAgendaPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DetalleAgendaPService {

    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private DetalleAgendaPRepository detalleAgendaPRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     * Obtener horarios disponibles para el paciente (por fecha y consultorio).
     */
    public List<DetalleAgendaPDTO> buscarDisponibles(Date fecha, Integer idMedico, Integer idConsultorio) {
        if (fecha == null || idConsultorio == null) {
            throw new IllegalArgumentException("La fecha y el consultorio son obligatorios.");
        }

        // Aquí puedes aplicar el filtro de médico si decides extender el query
        return detalleAgendaPRepository.findHorariosDisponiblesPaciente(fecha, idConsultorio);
    }

    /**
     * Agendar una cita a un paciente, asignándolo a un detalle_agenda disponible.
     */
    public boolean agendarCita(Integer idDetalle, Integer idPaciente) {
        try {
            DetalleAgenda detalle = detalleAgendaPRepository.findById(idDetalle)
                    .orElseThrow(() -> new RuntimeException("Detalle de agenda no encontrado con ID: " + idDetalle));

            if (!"Disponible".equalsIgnoreCase(detalle.getDisponibilidad())) {
                return false; // No se puede agendar si ya está ocupado
            }

            Paciente paciente = pacienteRepository.findById(idPaciente)
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + idPaciente));

            detalle.setPaciente(paciente);
            detalle.setDisponibilidad("Ocupado");

            detalleAgendaPRepository.save(detalle);
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Error al agendar la cita: " + e.getMessage());
        }
    }
}

