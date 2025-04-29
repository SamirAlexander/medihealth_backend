package com.proyecto.medihealth.administrador.controllers;


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






}
