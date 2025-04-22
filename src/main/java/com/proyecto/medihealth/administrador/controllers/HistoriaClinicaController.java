package com.proyecto.medihealth.administrador.controllers;

import com.proyecto.medihealth.administrador.dtos.HistoriaClinicaDTO;
import com.proyecto.medihealth.common.models.HistoriaClinica;
import com.proyecto.medihealth.common.models.Usuario;
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
    // Obtener Historia Clinica POR ITEM
     @GetMapping("/{id}")
    public HistoriaClinica obtenerHistoriaClinicaPorId(@PathVariable("id") int id) {
        return historiaClinicaService.obtenerHistoriaClinicaPorId(id);}

    // GET /administrador/historias-clinicas
    // Listar Historias Clinicas
    @GetMapping
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaService.obtenerTodasLasHistoriasClinicas();
    }


    //GET /administrador/historias-clinicas/listar
    // Listar Historias Clinicas por item sin RecordMedico
    @GetMapping("/listar")
    public List<HistoriaClinica> obtenerHistoriasClinicasSinRecords() {
        return historiaClinicaService.obtenerHistoriasClinicasSinRecords();
    }

    // GET /administrador/historias-clinicas/documento/{id}
    // Obtener Historia Clinica por numero documento
    @GetMapping("/documento/{id}")
    public Usuario obtenerHistoriaClinicaPorDocumentoIdentidad(@PathVariable String id) {
        return historiaClinicaService.obtenerHistoriaClinicaPorDocumentoIdentidad(id);
    }



    // Crear Historia Clinica por item
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HistoriaClinica> createHistoriaClinica(@Valid @RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica savedHistoria = historiaClinicaService.createHistoriaClinica(historiaClinicaDTO);
        return ResponseEntity.ok(savedHistoria);
    }


}
