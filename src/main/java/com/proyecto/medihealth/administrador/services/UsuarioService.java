package com.proyecto.medihealth.administrador.services;

import java.util.List;

import com.proyecto.medihealth.common.models.Usuario;
import com.proyecto.medihealth.administrador.dtos.UsuarioDTO;
import com.proyecto.medihealth.administrador.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // POST /Crear nuevo usuario
    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        usuario.setDocumentoIdentidad(usuarioDTO.getDocumentoIdentidad());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setRol(usuarioDTO.getRol());


        return usuarioRepository.save(usuario);
    }
    // GET /Obtener usuario por ID
    public Usuario obtenerUsuarioPorId(int id) {
        java.util.Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }
    // GET /Obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }
    // PUT /Actualizar un usuario
    public Usuario actualizarUsuario(int id, UsuarioDTO usuarioDTO) {
        java.util.Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setDocumentoIdentidad(usuarioDTO.getDocumentoIdentidad());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setTelefono(usuarioDTO.getTelefono());
            usuario.setCorreo(usuarioDTO.getCorreo());
            usuario.setContrasena(usuarioDTO.getContrasena());
            usuario.setRol(usuarioDTO.getRol());
            usuario.setIdUsuario(usuarioDTO.getIdUsuario());

            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}
