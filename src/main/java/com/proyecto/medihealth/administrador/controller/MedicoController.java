package com.proyecto.medihealth.administrador.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.medihealth.administrador.dto.MedicoDTO;
import com.proyecto.medihealth.administrador.model.Medico;
import com.proyecto.medihealth.administrador.service.MedicoService;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/administrador/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // POST /administrador/medicos
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico crearMedico(@RequestBody MedicoDTO medicoDTO) {
        return medicoService.crearMedico(medicoDTO);
    }

    // GET /administrador/medicos/{id}
    @GetMapping("/{id}")
    public Medico obtenerMedico(@PathVariable int id) {
        return medicoService.obtenerMedicoPorId(id);
    }

    // GET /administrador/medicos
    @GetMapping
    public List<Medico> obtenerTodosMedicos() {
        return medicoService.obtenerTodosMedicos();
    }

    // PUT /administrador/medicos/{id}
    @PutMapping("/{id}")
    public Medico actualizarMedico(@PathVariable int id, @RequestBody MedicoDTO medicoDTO) {
        return medicoService.actualizarMedico(id, medicoDTO);
    }

    // DELETE /administrador/medicos/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarMedico(@PathVariable int id) {
        medicoService.eliminarMedico(id);
    }
}