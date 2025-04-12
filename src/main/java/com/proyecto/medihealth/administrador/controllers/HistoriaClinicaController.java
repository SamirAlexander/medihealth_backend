package com.proyecto.medihealth.administrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.proyecto.medihealth.administrador.services.HistoriaClinicaService;
import com.proyecto.medihealth.common.models.HistoriaClinica;

import java.util.List;

public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    // GET /administrador/historiaClinica/{id}
    // Obtener Historia Clinica
     @GetMapping("/{id}")
    public HistoriaClinica obtenerHistoriaClinicaPorId(@PathVariable("id") int id) {
        return historiaClinicaService.obtenerHistoriaClinicaPorId(id);}

    // GET /administrador/historiaClinica
    // Listar Historias Clinicas
    @GetMapping
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaService.obtenerTodasLasHistoriasClinicas();
    }
}
