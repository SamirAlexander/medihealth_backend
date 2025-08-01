package com.proyecto.medihealth.administrador.services;

import java.util.List;

import com.proyecto.medihealth.administrador.repositories.UsuarioRepository;
import com.proyecto.medihealth.common.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.medihealth.administrador.dtos.PacienteDTO;
import com.proyecto.medihealth.common.models.Paciente;
import com.proyecto.medihealth.administrador.repositories.PacienteRepository;

@Service
public class PacienteService {

  @Autowired
  private PacienteRepository pacienteRepository;
  private UsuarioRepository usuarioRepository;

  // POST /Crear nuevo paciente
  public Paciente crearPaciente(PacienteDTO pacienteDTO) {



    Paciente paciente = new Paciente();
    paciente.setIdPaciente(pacienteDTO.getIdPaciente());
    paciente.setHistorialMedico(pacienteDTO.getHistorialMedico());
    paciente.setNumeroSeguro(pacienteDTO.getNumeroSeguro());
    paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
    paciente.setSexo(pacienteDTO.getSexo());
    paciente.setDireccion(pacienteDTO.getDireccion());
    paciente.setUltimaCita(pacienteDTO.getUltimaCita());
    paciente.setProximaCita(pacienteDTO.getProximaCita());


    return pacienteRepository.save(paciente);
  }

  // GET /Obtener paciente por ID
  public Paciente obtenerPacientePorId(int id) {
    java.util.Optional<Paciente> paciente = pacienteRepository.findById(id);
    return paciente.orElse(null);
  }

  // GET /Obtener todos los pacientes
  public List<Paciente> obtenerTodosPacientes() {
    return pacienteRepository.findAll();
  }

  // PUT /Actualizar un paciente
  public Paciente actualizarPaciente(int id, PacienteDTO pacienteDTO) {
    java.util.Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);

    if (pacienteExistente.isPresent()) {
      Paciente paciente = pacienteExistente.get();
      paciente.setIdPaciente(pacienteDTO.getIdPaciente());
      paciente.setHistorialMedico(pacienteDTO.getHistorialMedico());
      paciente.setNumeroSeguro(pacienteDTO.getNumeroSeguro());
      paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
      paciente.setSexo(pacienteDTO.getSexo());
      paciente.setDireccion(pacienteDTO.getDireccion());
      paciente.setUltimaCita(pacienteDTO.getUltimaCita());
      paciente.setProximaCita(pacienteDTO.getProximaCita());


      return pacienteRepository.save(paciente);
    }

    return null; // O lanzar excepción si no existe
  }

  // DELETE /Eliminar un paciente
  public void eliminarPaciente(int id) {
    pacienteRepository.deleteById(id);
  }
}
