package com.proyecto.medihealth.medico.controllers;

import com.proyecto.medihealth.medico.dtos.DetalleAgendaMDTO;
import com.proyecto.medihealth.medico.dtos.PacienteMDTO;
import com.proyecto.medihealth.medico.services.DetalleAgendaMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/medico/CitaExtra")
public class DetalleAgendaMController {

    @Autowired
    private DetalleAgendaMService detalleAgendaMService;

    // GET obtener id del paciente por documento de identidad
    // GET/medico/CitaExtra/obtener-id/{documento}
    @GetMapping("/obtener-id/{documento}")
    public ResponseEntity<PacienteMDTO> obtenerPacientePorDocumento(@PathVariable String documento) {
        System.out.println("🔎 Documento recibido en el controller: '" + documento + "'");
        PacienteMDTO dto = detalleAgendaMService.obtenerPacientePorDocumento(documento);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    // GET para obtener horarios disponibles por fecha y consultorio
    // GET/medico/CitaExtra/disponibles?fecha=&idConsultorio=
    @GetMapping("/disponibles")
    public ResponseEntity<List<DetalleAgendaMDTO>> getHorariosDisponibles(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam(required = false) Integer idMedico,
            @RequestParam Integer idConsultorio
    ) {
        List<DetalleAgendaMDTO> disponibles = detalleAgendaMService.buscarDisponibles(fecha, idMedico, idConsultorio);
        return ResponseEntity.ok(disponibles);
    }

    // POST para agendar una cita
    // POST/medico/CitaExtra/agendar/{idDetalle}?idPaciente=
    @PostMapping("/agendar/{idDetalle}")
    public ResponseEntity<String> agendarCita(
            @PathVariable Integer idDetalle,
            @RequestParam Integer idPaciente
    ) {
        boolean resultado = detalleAgendaMService.agendarCita(idDetalle, idPaciente);
        if (resultado) {
            return ResponseEntity.ok("Cita agendada exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo agendar la cita. Ya está ocupada o no existe.");
        }
    }



}
