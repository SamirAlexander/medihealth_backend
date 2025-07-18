package com.proyecto.medihealth.paciente.controllers;


import com.proyecto.medihealth.paciente.dtos.DetalleAgendaPDTO;
import com.proyecto.medihealth.paciente.dtos.PacientePDTO;
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

    // GET obtener id del paciente por documento de identidad
    // GET/paciente/obtener-id/{documento}
    @GetMapping("/obtener-id/{documento}")
    public ResponseEntity<PacientePDTO> obtenerPacientePorDocumento(@PathVariable String documento) {
        System.out.println("🔎 Documento recibido en el controller: '" + documento + "'");
        PacientePDTO dto = detalleAgendaPService.obtenerPacientePorDocumento(documento);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }


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

    // PUT PARA REASIGNAR UNA CITA
    // PUT/paciente/asignacionCita/reasignar/{idDetalleNuevo}?idPaciente=1&idDetalleAnterior=
    @PutMapping("/reasignar/{idDetalleNuevo}")
    public ResponseEntity<String> reasignarCita(
            @PathVariable Integer idDetalleNuevo,
            @RequestParam Integer idPaciente,
            @RequestParam Integer idDetalleAnterior
    ) {
        boolean resultado = detalleAgendaPService.reasignarCita(idDetalleNuevo, idPaciente, idDetalleAnterior);
        if (resultado) {
            return ResponseEntity.ok("Cita reasignada exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo reasignar la cita.");
        }
    }

    // DELETE PARA CANCELAR UNA CITA
    // DELETE/paciente/asignacionCita/cancelar/{idDetalle}
    @DeleteMapping("/cancelar/{idDetalle}")
    public ResponseEntity<String> cancelarCita(@PathVariable Integer idDetalle) {
        boolean resultado = detalleAgendaPService.cancelarCita(idDetalle);
        if (resultado) {
            return ResponseEntity.ok("Cita cancelada exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo cancelar la cita. Puede que no exista o ya esté cancelada.");
        }
    }

}
