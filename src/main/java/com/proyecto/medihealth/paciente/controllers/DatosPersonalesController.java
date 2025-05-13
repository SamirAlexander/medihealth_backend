package com.proyecto.medihealth.paciente.controllers;


import com.proyecto.medihealth.common.models.Usuario;
import com.proyecto.medihealth.paciente.services.DatosPersonalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/paciente/datosPersonales")

public class DatosPersonalesController {

    @Autowired
    private DatosPersonalesService datosPersonalesService;

    // GET /paciente/datosPersonales/{id}
    // Obtener Datos Personales
    @GetMapping("/{documentoIdentidad}")
    public Usuario obtenerDatosPersonales(@PathVariable("documentoIdentidad") String documentoIdentidad) {
        return datosPersonalesService.obtenerDatosPersonalesPordocumentoIdentidad(documentoIdentidad);
    }

    // PUT /paciente/datosPersonales/{id}
    // Modificar Datos Personales
    @PutMapping("/{documentoIdentidad}")
    public Usuario modificarDatosPersonales(@PathVariable("documentoIdentidad") String doccumentoIdentidad, @RequestBody Usuario datosPersonales) {
        return datosPersonalesService.actualizarDatosPersonales(doccumentoIdentidad, datosPersonales);
    }



}
