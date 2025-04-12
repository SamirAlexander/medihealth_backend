package com.proyecto.medihealth.administrador.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.medihealth.administrador.dtos.MedicoDTO;
import com.proyecto.medihealth.common.models.Medico;
import com.proyecto.medihealth.administrador.repositories.MedicoRepository;


@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // POST /Crear nuevo médico
    public Medico crearMedico(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        /* medico.setIdUsuario(medicoDTO.getIdUsuario()); */
        medico.setDependencia(medicoDTO.getDependencia());
        medico.setHorarioTrabajo(medicoDTO.getHorarioTrabajo());
        medico.setNumeroLicencia(medicoDTO.getNumeroLicencia());
        medico.setAreaEspecializacion(medicoDTO.getAreaEspecializacion());
        medico.setNoConsultorio(medicoDTO.getNoConsultorio());
        
        return medicoRepository.save(medico);
    }

    // GET /Obtener médico por ID
    public Medico obtenerMedicoPorId(int id) {
        java.util.Optional<Medico> medico = medicoRepository.findById(id);
        return medico.orElse(null);
    }

    // GET /Obtener todos los médicos
    public List<Medico> obtenerTodosMedicos() {
        return medicoRepository.findAll();
    }

    // PUT /Actualizar un médico
    public Medico actualizarMedico(int id, MedicoDTO medicoDTO) {
        java.util.Optional<Medico> medicoExistente = medicoRepository.findById(id);
        
        if (medicoExistente.isPresent()) {
            Medico medico = medicoExistente.get();
           /*  medico.setIdUsuario(medicoDTO.getIdUsuario()); */
            medico.setDependencia(medicoDTO.getDependencia());
            medico.setHorarioTrabajo(medicoDTO.getHorarioTrabajo());
            medico.setNumeroLicencia(medicoDTO.getNumeroLicencia());
            medico.setAreaEspecializacion(medicoDTO.getAreaEspecializacion());
            medico.setNoConsultorio(medicoDTO.getNoConsultorio());
            
            return medicoRepository.save(medico);
        }
        
        return null; // O lanzar excepción si no existe
    }

    // DELETE /Eliminar un médico
    public void eliminarMedico(int id) {
        medicoRepository.deleteById(id);
    }
}