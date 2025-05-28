package com.proyecto.medihealth.medico.controllers;



import com.proyecto.medihealth.medico.dtos.AgendaDelDiaDTO;
import com.proyecto.medihealth.medico.services.AgendaDelDiaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/medico/agendaDelDia")
public class AgendaDelDiaController {

    private final AgendaDelDiaService agendaDelDiaService;

    public AgendaDelDiaController(AgendaDelDiaService agendaDelDiaService) {
        this.agendaDelDiaService = agendaDelDiaService;
    }

    //Get agenda del dia por consultorio y fecha
    // Get /medico/{idConsultorio}
    // GET medico/agendaDelDia/1?fecha={}
    @GetMapping("/{idConsultorio}")
    public ResponseEntity<List<AgendaDelDiaDTO>> getAgendaDelDia(
            @PathVariable Integer idConsultorio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        List<AgendaDelDiaDTO> agenda = (fecha == null)
                ? agendaDelDiaService.obtenerAgendaHoy(idConsultorio)
                : agendaDelDiaService.obtenerAgendaDelDia(idConsultorio, fecha);

        return ResponseEntity.ok(agenda);
    }
}