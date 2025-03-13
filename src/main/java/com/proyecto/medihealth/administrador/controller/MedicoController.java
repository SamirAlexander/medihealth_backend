package com.proyecto.medihealth.administrador.controller;


import com.example.demo.model.Medico;
import com.proyecto.medihealth.administrador.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/administrador/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    // Crear un nuevo médico
    @PostMapping
    public ResponseEntity<Medico> crearMedico(@RequestBody Medico medico) {
        Medico nuevoMedico = medicoRepository.save(medico);
        return new ResponseEntity<>(nuevoMedico, HttpStatus.CREATED);
    }

    // Obtener un médico por su id
    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerMedico(@PathVariable int id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isPresent()) {
            return new ResponseEntity<>(medico.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Actualizar un médico
    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizarMedico(@PathVariable int id, @RequestBody Medico medico) {
        if (medicoRepository.existsById(id)) {
            medico.setIdMedico(id);
            Medico medicoActualizado = medicoRepository.save(medico);
            return new ResponseEntity<>(medicoActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un médico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable int id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
