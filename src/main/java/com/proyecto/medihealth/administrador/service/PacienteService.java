package com.proyecto.medihealth.administrador.service;

import org.springframework.stereotype.Service;

import com.proyecto.medihealth.administrador.dto.PacienteDTO;
import com.proyecto.medihealth.administrador.model.Paciente;
import com.proyecto.medihealth.administrador.repository.PacienteRepository;

@Service
public class PacienteService {

  private final PacienteRepository pacienteRepository;

  public PacienteService(PacienteRepository pacienteRepository) {
    this.pacienteRepository = pacienteRepository;
  }

 
 /*  public Paciente save(PacienteDTO pacienteDTO) {
    Paciente paciente = new Paciente();
    paciente.setIdPaciente(pacienteDTO.getIdPaciente());


    return pacienteRepository.save(pacienteDTO);
  } */

}