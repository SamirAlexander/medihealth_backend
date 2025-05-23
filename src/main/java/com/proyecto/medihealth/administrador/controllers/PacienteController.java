package com.proyecto.medihealth.administrador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.medihealth.administrador.dtos.PacienteDTO;
import com.proyecto.medihealth.common.models.Paciente;
import com.proyecto.medihealth.administrador.services.PacienteService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/administrador/pacientes")
public class PacienteController {

  @Autowired
  private PacienteService pacienteService;

  // POST /administrador/pacientes
  // Agregar Paciente
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> crearPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {
    pacienteService.crearPaciente(pacienteDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body("Se creo correctamente");
  }

  // GET /administrador/pacientes/{id}
  // Obtener Paciente
  @GetMapping("/{id}")
  public Paciente obtenerPaciente(@PathVariable("id") int id) {
    return pacienteService.obtenerPacientePorId(id);
  }

  // GET /administrador/pacientes
  // Listar Pacientes
  @GetMapping
  public List<Paciente> obtenerTodosPacientes() {
    return pacienteService.obtenerTodosPacientes();
  }

  // PUT /administrador/pacientes/{id}
  // Modificar Pacientes
  @PutMapping("/{id}")
  public ResponseEntity<String> actualizarPaciente(@PathVariable("id") int id,
      @Valid @RequestBody PacienteDTO pacienteDTO) {
    pacienteService.actualizarPaciente(id, pacienteDTO);
    return ResponseEntity.status(HttpStatus.OK).body("Se modifico Paciente");
  }

  // DELETE /administrador/pacientes/{id}
  // Eliminar Paciente
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<String> eliminarPaciente(@PathVariable("id") int id) {
    pacienteService.eliminarPaciente(id);
    return ResponseEntity.status(HttpStatus.OK).body("Se elimina Registro");
  }
}