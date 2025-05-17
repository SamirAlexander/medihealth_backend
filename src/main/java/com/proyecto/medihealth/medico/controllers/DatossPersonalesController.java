package com.proyecto.medihealth.medico.controllers;


import com.proyecto.medihealth.common.models.Usuario;
import com.proyecto.medihealth.medico.services.DatossPersonalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/medico/datossPersonales")

public class DatossPersonalesController {

    @Autowired
    private DatossPersonalesService datossPersonalesService;
    // GET /medico/datossPersonales/{id}
    // Obtener Datos Personales
     @GetMapping("/{documentoIdentidad}")
    public Usuario obtenerDatosPersonales(@PathVariable("documentoIdentidad") String documentoIdentidad) {
        return datossPersonalesService.obtenerDatossPersonalesPordocumentoIdentidad(documentoIdentidad);
     }

    // PUT /medico/datossPersonales/{id}
    // Modificar Datos Personales
    @PutMapping("/{documentoIdentidad}")
    public Usuario modificarDatosPersonales(@PathVariable("documentoIdentidad") String documentoIdentidad, @RequestBody Usuario datosPersonales) {
        return datossPersonalesService.actualizarDatossPersonales(documentoIdentidad, datosPersonales);
    }
}

