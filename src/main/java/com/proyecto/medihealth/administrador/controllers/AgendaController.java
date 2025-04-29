package com.proyecto.medihealth.administrador.controllers;


import com.proyecto.medihealth.administrador.dtos.AgendaDTO;
import com.proyecto.medihealth.administrador.services.AgendaService;
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
    public List<AgendaDTO> obtenerAgendas() {
         return agendaService.obtenerAgendas();
    }

  // GET /administrador/agenda/detalleAgenda
    // Listar Detalle Agendas
     @GetMapping("/detalleAgenda")
    public List<DetalleAgenda> obtenerDetalleAgendas() {
         return agendaService.obtenerDetalleAgendas();
    }




}
