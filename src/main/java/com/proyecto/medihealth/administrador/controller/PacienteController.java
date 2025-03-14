package com.proyecto.medihealth.administrador.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.medihealth.administrador.dto.PacienteDTO;
import com.proyecto.medihealth.administrador.model.Paciente;
import com.proyecto.medihealth.administrador.service.PacienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/administrador/paciente")
public class PacienteController {

  private final PacienteService pacienteService;

  PacienteController(PacienteService pacienteService) {
    this.pacienteService = pacienteService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> save(@RequestBody PacienteDTO pacienteDTO) {
    //System.out.println("pacienteDTO");
    return ResponseEntity.status(HttpStatus.CREATED).body("Paciente registrado correctamente");
  }

}
