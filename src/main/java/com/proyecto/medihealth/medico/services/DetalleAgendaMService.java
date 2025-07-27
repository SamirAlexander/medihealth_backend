package com.proyecto.medihealth.medico.services;

import com.proyecto.medihealth.administrador.repositories.AgendaRepository;
import com.proyecto.medihealth.common.models.DetalleAgenda;
import com.proyecto.medihealth.common.models.Paciente;
import com.proyecto.medihealth.medico.dtos.DetalleAgendaMDTO;
import com.proyecto.medihealth.medico.dtos.PacienteMDTO;
import com.proyecto.medihealth.medico.repositories.DetalleAgendaMRepository;
import com.proyecto.medihealth.medico.repositories.PacienteMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DetalleAgendaMService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private DetalleAgendaMRepository detalleAgendaMRepository;

    @Autowired
    private PacienteMRepository pacienteRepository;

    /**
     * Obtener el ID del paciente por su documento de identidad.
     */
    public PacienteMDTO obtenerPacientePorDocumento(String documento) {
        System.out.println("➡️ Buscando paciente con documento: " + documento);

        Paciente paciente = pacienteRepository.buscarPorDocumento(documento);

        if (paciente == null) {
            System.out.println("❌ No se encontró paciente con ese documento");
            return null;
        }

        System.out.println("✅ Paciente encontrado: " + paciente.getUsuario().getNombre() + " " + paciente.getUsuario().getApellido());

        return new PacienteMDTO(
                paciente.getIdPaciente(),
                paciente.getUsuario().getDocumentoIdentidad(),
                paciente.getUsuario().getNombre(),
                paciente.getUsuario().getApellido()
        );
    }


    /**
     * Obtener horarios disponibles para el paciente (por fecha y consultorio).
     */
    public List<DetalleAgendaMDTO> buscarDisponibles(Date fecha, Integer idMedico, Integer idConsultorio) {
        if (fecha == null || idConsultorio == null) {
            throw new IllegalArgumentException("La fecha y el consultorio son obligatorios.");
        }

        // Aquí puedes aplicar el filtro de médico si decides extender el query
        return detalleAgendaMRepository.findHorariosDisponiblesPaciente(fecha, idConsultorio);
    }

    /**
     * Agendar una cita a un paciente, asignándolo a un detalle_agenda disponible.
     */
    public boolean agendarCita(Integer idDetalle, Integer idPaciente) {
        try {
            DetalleAgenda detalle = detalleAgendaMRepository.findById(idDetalle)
                    .orElseThrow(() -> new RuntimeException("Detalle de agenda no encontrado con ID: " + idDetalle));

            if (!"Disponible".equalsIgnoreCase(detalle.getDisponibilidad())) {
                return false; // No se puede agendar si ya está ocupado
            }

            Paciente paciente = pacienteRepository.findById(idPaciente)
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + idPaciente));

            detalle.setPaciente(paciente);
            detalle.setDisponibilidad("Ocupado");

            detalleAgendaMRepository.save(detalle);
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Error al agendar la cita: " + e.getMessage());
        }
    }

}
