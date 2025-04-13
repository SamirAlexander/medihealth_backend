package com.proyecto.medihealth.administrador.controllers;

import com.proyecto.medihealth.administrador.dtos.HistoriaClinicaDTO;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.medihealth.administrador.services.HistoriaClinicaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/administrador/historias-clinicas")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    // GET /administrador/historias-clinicas/{id}
    // Obtener Historia Clinica
     @GetMapping("/{id}")
    public HistoriaClinica obtenerHistoriaClinicaPorId(@PathVariable("id") int id) {
        return historiaClinicaService.obtenerHistoriaClinicaPorId(id);}

    // GET /administrador/historias-clinicas
    // Listar Historias Clinicas
    @GetMapping
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaService.obtenerTodasLasHistoriasClinicas();
    }

    //POST /administrador/historias-clinicas
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HistoriaClinica> createHistoriaClinica(@Valid @RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica savedHistoria = historiaClinicaService.createHistoriaClinica(historiaClinicaDTO);
        return ResponseEntity.ok(savedHistoria);
    }

}
