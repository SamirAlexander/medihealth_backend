package com.proyecto.medihealth.administrador.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.medihealth.administrador.dto.AdministradorDTO;
import com.proyecto.medihealth.administrador.model.Administrador;
import com.proyecto.medihealth.administrador.repository.AdministradorRepository;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    // POST /Crear nuevo administrador
    public Administrador crearAdministrador(AdministradorDTO administradorDTO) {
        Administrador administrador = new Administrador();
        administrador.setIdAdmin(administradorDTO.getIdAdmin());
        administrador.setDepartamento(administradorDTO.getDepartamento());
        administrador.setNivelAcceso(administradorDTO.getNivelAcceso());
        administrador.setAreaAsignada(administradorDTO.getAreaAsignada());
        administrador.setTareasAsignadas(administradorDTO.getTareasAsignadas());

        return administradorRepository.save(administrador);
    }

    // GET /Obtener administrador por ID
    public Administrador obtenerAdministradorPorId(int id) {
        java.util.Optional<Administrador> administrador = administradorRepository.findById(id);
        return administrador.orElse(null);
    }

    // GET /Obtener todos los administradores
    public List<Administrador> obtenerTodosAdministradores() {
        return administradorRepository.findAll();
    }

    // PUT /Actualizar un administrador
    public Administrador actualizarAdministrador(int id, AdministradorDTO administradorDTO) {
        java.util.Optional<Administrador> administradorExistente = administradorRepository.findById(id);
        
        if (administradorExistente.isPresent()) {
            Administrador administrador = administradorExistente.get();
            administrador.setIdAdmin(administradorDTO.getIdAdmin());
            administrador.setDepartamento(administradorDTO.getDepartamento());
            administrador.setNivelAcceso(administradorDTO.getNivelAcceso());
            administrador.setAreaAsignada(administradorDTO.getAreaAsignada());
            administrador.setTareasAsignadas(administradorDTO.getTareasAsignadas());
            
            return administradorRepository.save(administrador);
        }

        return null; // O lanzar excepción si no existe
    }

    // DELETE /Eliminar un administrador
    public void eliminarAdministrador(int id) {
        administradorRepository.deleteById(id);
    }
}
