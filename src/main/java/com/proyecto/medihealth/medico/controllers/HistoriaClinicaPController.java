package com.proyecto.medihealth.medico.controllers;


import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.medico.dtos.HistoriaClinicaPDTO;
import com.proyecto.medihealth.medico.services.HistoriaClinicaPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/medico/historiaClinicaP")
public class HistoriaClinicaPController {

    @Autowired
    private HistoriaClinicaPService historiaClinicaPService;


    //GET /medico/historiaClinicaP/documento/{documentoIdentidad}
    // Obtener Historia Clinica por Documento de Identidad
    @GetMapping("/documento/{documentoIdentidad}")
    public ResponseEntity<?> obtenerHistoriaClinicaPorDocumentoIdentidad(@PathVariable("documentoIdentidad") String documentoIdentidad) {
        List<HistoriaClinicaPDTO> historiaClinica = historiaClinicaPService.obtenerHistoriaClinicaPorDocumentoIdentidad(documentoIdentidad);

        if (historiaClinica == null || historiaClinica.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "No se encontró la historia clínica para el documento: " + documentoIdentidad);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(historiaClinica);


    }
}



