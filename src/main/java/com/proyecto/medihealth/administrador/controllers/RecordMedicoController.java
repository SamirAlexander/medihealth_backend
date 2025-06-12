package com.proyecto.medihealth.administrador.controllers;


import com.proyecto.medihealth.administrador.dtos.RecordMedicoDTO;
import com.proyecto.medihealth.administrador.services.RecordMedicoService;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.common.models.RecordMedico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/administrador/record-medicos")
public class RecordMedicoController {

    @Autowired RecordMedicoService recordMedicoService;

    // PUT /administrador/record-medicos/{id}
    // Agregar Record Medico a una historia clínica existente por ID (Item).
    @PutMapping("/{id}")
    public ResponseEntity<RecordMedico> updateHistoriaClinica(@PathVariable int id, @Valid @RequestBody RecordMedicoDTO recordMedicoDTO) {
        RecordMedico updatedRecord = recordMedicoService.agregarRecordAHistoria(id, recordMedicoDTO);
        return ResponseEntity.ok(updatedRecord);
    }

    // GET /administrador/record-medicos/{id}
    // Obtener un record médico por numero_historia.
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> getRecordMedico(@PathVariable int id) {
        HistoriaClinica historiaClinica = recordMedicoService.obtenerHistoriaClinicaPorNumeroHistoria(id);
        return ResponseEntity.ok(historiaClinica);
    }


}
