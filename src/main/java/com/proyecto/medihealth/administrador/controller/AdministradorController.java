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
import com.proyecto.medihealth.administrador.dto.AdministradorDTO;
import com.proyecto.medihealth.administrador.model.Administrador;
import com.proyecto.medihealth.administrador.service.AdministradorService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/administrador/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    // POST /administrador/administradores
    // Agregar administrador
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> crearAdministrador(@Valid @RequestBody AdministradorDTO administradorDTO) {
        administradorService.crearAdministrador(administradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Administrador creado correctamente");
    }

    // GET /administrador/administradores/{id}
    // Obtener administrador
    @GetMapping("/{id}")
    public Administrador obtenerAdministrador(@PathVariable int id) {
        Administrador administrador = administradorService.obtenerAdministradorPorId(id);
        if (administrador != null) {
            return administrador;
        }
        return null; // O lanzar una excepción si el administrador no existe
    }

    // GET /administrador/administradores
    // Listar administrador
    @GetMapping
    public List<Administrador> obtenerTodosAdministradores() {
        return administradorService.obtenerTodosAdministradores();
    }

    // PUT /administrador/administradores/{id}
    // modificar admnistrador
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAdministrador(@PathVariable("id") int id, @Valid @RequestBody AdministradorDTO administradorDTO) {
        Administrador administrador = administradorService.actualizarAdministrador(id, administradorDTO);
        if (administrador != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Administrador actualizado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador no encontrado");
    }

    // DELETE /administrador/administradores/{id}
    // Eliminar administrador
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> eliminarAdministrador(@PathVariable int id) {
        administradorService.eliminarAdministrador(id);
        return ResponseEntity.status(HttpStatus.OK).body("Administrador eliminado correctamente");
    }
}
