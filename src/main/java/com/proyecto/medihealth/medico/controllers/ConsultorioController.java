package com.proyecto.medihealth.medico.controllers;

import com.proyecto.medihealth.common.models.Consultorios;
import com.proyecto.medihealth.medico.dtos.ConsultorioDTO;
import com.proyecto.medihealth.medico.services.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/medico/consultorio")
public class ConsultorioController {

    @Autowired
    private ConsultorioService consultorioService;


    // GET /medico/consultorio/
    // Obtener Datos Personales
    @GetMapping("/")
    public List<ConsultorioDTO> obtenerTodosConsultorios() {
        return consultorioService.obtenerTodosLosConsultorios();
    }

}
