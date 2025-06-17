package com.proyecto.medihealth.medico.controllers;


import com.proyecto.medihealth.common.models.RecordMedico;
import com.proyecto.medihealth.medico.dtos.NuevoRecordMedicoDTO;
import com.proyecto.medihealth.medico.services.NuevoRecordMedicoService;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/medico/nuevoRecordMedico")
public class NuevoRecordMedicoController {
    @Autowired
    NuevoRecordMedicoService recordMedicoService;

    //GET /medico/nuevoRecordMedico/{id}
    // Obtener Historia Clinica por ID (Item).
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> obtenerHistoriaClinicaPorId(@PathVariable int id) {
        HistoriaClinica historiaClinica = recordMedicoService.obtenerHistoriaClinicaPorId(id);
        return ResponseEntity.ok(historiaClinica);
    }

    // PUT /medico/nuevoRecordMedico/{id}
// Agregar Nuevo Record Medico a una historia clínica existente por ID (Item).
    @PutMapping("/{historiaId}")
    public ResponseEntity<RecordMedico> agregarRecordAHistoriaClinica(
            @PathVariable int historiaId,
            @Valid @RequestBody NuevoRecordMedicoDTO nuevoRecordMedicoDTO) {
        RecordMedico recordMedico = recordMedicoService.agregarRecordAHistoriaClinica(historiaId, nuevoRecordMedicoDTO);
        return ResponseEntity.ok(recordMedico);
    }

}
