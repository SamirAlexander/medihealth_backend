package com.proyecto.medihealth.medico.controllers;


import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.medico.services.HistoriaClinicaPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/medico/historiaClinicaP")
public class HistoriaClinicaPController {

    @Autowired
    private HistoriaClinicaPService historiaClinicaPService;

    //GET /medico/historiaClinicaP/{id}
    // Obtener Historia Clinica por ID
    @GetMapping("/{id}")
    public HistoriaClinica obtenerHistoriaClinicaPorId(@PathVariable("id") int id) {
        return historiaClinicaPService.obtenerHistoriaClinicaPorId(id);
    }

    //GET /medico/historiaClinicaP/documento/{documentoIdentidad}
    // Obtener Historia Clinica por Documento de Identidad
    @GetMapping("/documento/{documentoIdentidad}")
    public HistoriaClinica obtenerHistoriaClinicaPorDocumentoIdentidad(@PathVariable("documentoIdentidad") String documentoIdentidad) {
        return historiaClinicaPService.obtenerHistoriaClinicaPorDocumentoIdentidad(documentoIdentidad);
    }

}
