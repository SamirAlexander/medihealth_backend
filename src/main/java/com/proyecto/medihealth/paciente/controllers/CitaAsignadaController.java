package com.proyecto.medihealth.paciente.controllers;

import com.proyecto.medihealth.paciente.dtos.CitaAsignadaDTO;
import com.proyecto.medihealth.paciente.services.CitaAsignadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/paciente/citaAsignada")
public class CitaAsignadaController {

    @Autowired
    private CitaAsignadaService citaAsignadaService;

    // GET /paciente/citaAsignada/documento/{documentoIdentidad}
    @GetMapping("/documento/{documentoIdentidad}")
    public ResponseEntity<List<CitaAsignadaDTO>> getCitasPorDocumento(@PathVariable String documentoIdentidad) {
        List<CitaAsignadaDTO> citas = citaAsignadaService.obtenerCitasPorDocumentoPaciente(documentoIdentidad);
        if (citas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(citas);
    }
}