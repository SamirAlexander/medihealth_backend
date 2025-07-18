    package com.proyecto.medihealth.paciente.services;
    
    
    import com.proyecto.medihealth.administrador.repositories.AgendaRepository;
    import com.proyecto.medihealth.common.models.DetalleAgenda;
    import com.proyecto.medihealth.common.models.Paciente;
    import com.proyecto.medihealth.common.models.Usuario;
    import com.proyecto.medihealth.paciente.dtos.DetalleAgendaPDTO;
    import com.proyecto.medihealth.paciente.dtos.PacientePDTO;
    import com.proyecto.medihealth.paciente.repositories.DetalleAgendaPRepository;
    import com.proyecto.medihealth.paciente.repositories.PacientePRepository;
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
        private PacientePRepository pacienteRepository;
    
        /**
         * Obtener el ID del paciente por su documento de identidad.
         */
        public PacientePDTO obtenerPacientePorDocumento(String documento) {
            System.out.println("➡️ Buscando paciente con documento: " + documento);

            Paciente paciente = pacienteRepository.buscarPorDocumento(documento);

            if (paciente == null) {
                System.out.println("❌ No se encontró paciente con ese documento");
                return null;
            }

            Usuario usuario = paciente.getUsuario();

            System.out.println("✅ Paciente encontrado: " + usuario.getNombre() + " " + usuario.getApellido());

            return new PacientePDTO(
                    paciente.getIdPaciente(),
                    usuario.getDocumentoIdentidad(),
                    usuario.getNombre(),
                    usuario.getApellido()
            );
        }
    
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
         * Obtener horarios disponibles para el paciente por especialidad del médico.
         */
        public List<DetalleAgendaPDTO> buscarDisponiblesPorEspecialidad(Date fecha, Integer idConsultorio, String especialidad) {
            if (fecha == null || idConsultorio == null || especialidad == null || especialidad.isEmpty()) {
                throw new IllegalArgumentException("La fecha, el consultorio y la especialidad son obligatorios.");
            }
    
            // Aquí puedes aplicar el filtro de especialidad si decides extender el query
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
    
        /**
         * Reasignar una cita a un paciente, asignándolo a un detalle_agenda disponible.
         */
        public boolean reasignarCita(Integer idNuevoDetalle, Integer idPaciente, Integer idDetalleAnterior) {
            try {
                DetalleAgenda nuevoDetalle = detalleAgendaPRepository.findById(idNuevoDetalle)
                        .orElseThrow(() -> new RuntimeException("Nueva cita no encontrada con ID: " + idNuevoDetalle));
    
                if (!"Disponible".equalsIgnoreCase(nuevoDetalle.getDisponibilidad())) {
                    return false;
                }
    
                // Liberar solo la cita anterior
                DetalleAgenda citaAnterior = detalleAgendaPRepository.findById(idDetalleAnterior)
                        .orElseThrow(() -> new RuntimeException("Cita anterior no encontrada con ID: " + idDetalleAnterior));
    
                citaAnterior.setPaciente(null);
                citaAnterior.setDisponibilidad("Disponible");
                detalleAgendaPRepository.save(citaAnterior);
    
                // Asignar nueva cita
                Paciente paciente = pacienteRepository.findById(idPaciente)
                        .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + idPaciente));
    
                nuevoDetalle.setPaciente(paciente);
                nuevoDetalle.setDisponibilidad("Ocupado");
                detalleAgendaPRepository.save(nuevoDetalle);
    
                return true;
    
            } catch (Exception e) {
                throw new RuntimeException("Error al reasignar la cita: " + e.getMessage());
            }
        }
    
        /**
         * Cancelar una cita, liberando el detalle_agenda.
         */
        public boolean cancelarCita(Integer idDetalleAgenda) {
            try {
                DetalleAgenda detalle = detalleAgendaPRepository.findById(idDetalleAgenda)
                        .orElseThrow(() -> new RuntimeException("Detalle de agenda no encontrado con ID: " + idDetalleAgenda));
    
                // Solo cancelar si está ocupado
                if (!"Ocupado".equalsIgnoreCase(detalle.getDisponibilidad())) {
                    return false; // Ya estaba disponible o no se puede cancelar
                }
    
                // Liberar el cupo
                detalle.setPaciente(null);
                detalle.setDisponibilidad("Disponible");
    
                // Guardar los cambios
                detalleAgendaPRepository.save(detalle);
    
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error al cancelar la cita: " + e.getMessage());
            }
        }
    }
    
