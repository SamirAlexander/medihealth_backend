package com.proyecto.medihealth.administrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.medihealth.administrador.dto.UsuarioDTO;
import com.proyecto.medihealth.administrador.model.Usuario;
import com.proyecto.medihealth.administrador.service.UsuarioService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/administrador/usuarios")


public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // POST /administrador/usuarios
    // Agregar Usuario
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se creo correctamente");
    }
    // GET /administrador/usuarios/{id}
    // Obtener Usuario
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable("id") int id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }
    // GET /administrador/usuarios
    // Listar Usuarios
    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }
    // PUT /administrador/usuarios/{id}
    // Modificar Usuario
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable("id") int id,
        @Valid @RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.actualizarUsuario(id, usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Se actualizo correctamente");
    }
    // DELETE /administrador/usuarios/{id}
    // Eliminar Usuario
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuario(@PathVariable("id") int id) {
        usuarioService.eliminarUsuario(id);
    }

}
