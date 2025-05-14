package com.proyecto.medihealth.administrador.controllers;


import com.proyecto.medihealth.administrador.data.PeriodoAgendaRequest;
import com.proyecto.medihealth.administrador.data.PeriodoAgendaResponse;
import com.proyecto.medihealth.administrador.dtos.AgendaDTO;
import com.proyecto.medihealth.administrador.services.AgendaService;
import com.proyecto.medihealth.common.models.Agenda;
import com.proyecto.medihealth.common.models.DetalleAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/administrador/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    // GET /administrador/agenda
    // Listar Agendas
     @GetMapping
    public List<Agenda> obtenerAgendas() {
         return agendaService.obtenerAgendas();
    }

    // GET /administrador/agenda/{id}
    // Obtener Agenda por ID
    @GetMapping("/{id}")
    public Agenda obtenerAgendaPorId(@PathVariable("id") int id) {
        return agendaService.obtenerAgendaPorId(id);
    }

    // POST /administrador/agenda
    // Crear Agenda
    @PostMapping
    public PeriodoAgendaResponse crearAgenda(@RequestBody PeriodoAgendaRequest request) {
         return agendaService.crearAgendaPeriodo(request);
    }


}
