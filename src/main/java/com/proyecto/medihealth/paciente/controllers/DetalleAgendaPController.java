package com.proyecto.medihealth.paciente.controllers;


import com.proyecto.medihealth.paciente.dtos.DetalleAgendaPDTO;
import com.proyecto.medihealth.paciente.services.DetalleAgendaPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/paciente/asignacionCita")
public class DetalleAgendaPController {

    @Autowired
    private DetalleAgendaPService detalleAgendaPService;

    // GET para obtener horarios disponibles por fecha y consultorio
    //GET/paciente/asignacionCita/disponibles?fecha=&idConsultorio=
    @GetMapping("/disponibles")
    public ResponseEntity<List<DetalleAgendaPDTO>> getHorariosDisponibles(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam(required = false) Integer idMedico,
            @RequestParam Integer idConsultorio
    ) {
        List<DetalleAgendaPDTO> disponibles = detalleAgendaPService.buscarDisponibles(fecha, idMedico, idConsultorio);
        return ResponseEntity.ok(disponibles);
    }

    // POST para agendar una cita
    // POST/paciente/asignacionCita/agendar/{idDetalle}?idPaciente=
    @PostMapping("/agendar/{idDetalle}")
    public ResponseEntity<String> agendarCita(
            @PathVariable Integer idDetalle,
            @RequestParam Integer idPaciente
    ) {
        boolean resultado = detalleAgendaPService.agendarCita(idDetalle, idPaciente);
        if (resultado) {
            return ResponseEntity.ok("Cita agendada exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo agendar la cita. Ya está ocupada o no existe.");
        }
    }

}
