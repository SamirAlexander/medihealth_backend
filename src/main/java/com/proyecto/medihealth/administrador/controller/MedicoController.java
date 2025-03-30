package com.proyecto.medihealth.administrador.controller;
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
import com.proyecto.medihealth.administrador.dto.MedicoDTO;
import com.proyecto.medihealth.administrador.model.Medico;
import com.proyecto.medihealth.administrador.service.MedicoService;


import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/administrador/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // POST /administrador/medicos
    // Agregar Medico
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> crearMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        medicoService.crearMedico(medicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se creo correctamente");
    }

    // GET /administrador/medicos/{id}
    //Obtener Medico
    @GetMapping("/{id}")
    public Medico obtenerMedico(@PathVariable("id") int id) {
        return medicoService.obtenerMedicoPorId(id);
    }

    // GET /administrador/medicos
    // Listar Medico
    @GetMapping
    public List<Medico> obtenerTodosMedicos() {
        return medicoService.obtenerTodosMedicos();
    }

    // PUT /administrador/medicos/{id}
    // Modificar Medico
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarMedico(@PathVariable("id") int id, @Valid @RequestBody MedicoDTO medicoDTO) {
        medicoService.actualizarMedico(id, medicoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Se modifico Medico");
    }

    // DELETE /administrador/medicos/{id}
    //Eliminar Medico
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> eliminarMedico(@PathVariable("id") int id) {
        medicoService.eliminarMedico(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se elimina Registro");
    }
}