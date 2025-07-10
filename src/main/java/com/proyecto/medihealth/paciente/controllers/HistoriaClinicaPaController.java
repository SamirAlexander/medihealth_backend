package com.proyecto.medihealth.paciente.controllers;

import com.proyecto.medihealth.paciente.dtos.HistoriaClinicaPaDTO;
import com.proyecto.medihealth.paciente.services.HistoriaClinicaPaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/paciente/historiaClinicaPa")
public class HistoriaClinicaPaController {

    @Autowired
    private HistoriaClinicaPaService historiaClinicaPaService;


    //GET /paciente/historiaClinicaPa/documento/{documentoIdentidad}
    // Obtener Historia Clinica por Documento de Identidad
    @GetMapping("/documento/{documentoIdentidad}")
    public ResponseEntity<?> obtenerHistoriaClinicaPorDocumentoIdentidad(@PathVariable("documentoIdentidad") String documentoIdentidad) {
        List<HistoriaClinicaPaDTO> historiaClinica = historiaClinicaPaService.obtenerHistoriaClinicaPorDocumentoIdentidad(documentoIdentidad);

        if (historiaClinica == null || historiaClinica.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "No se encontró la historia clínica para el documento: " + documentoIdentidad);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(historiaClinica);

    }
}
