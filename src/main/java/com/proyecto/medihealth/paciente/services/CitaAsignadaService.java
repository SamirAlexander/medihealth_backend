package com.proyecto.medihealth.paciente.services;

import com.proyecto.medihealth.paciente.dtos.CitaAsignadaDTO;
import com.proyecto.medihealth.paciente.repositories.CitaAsignadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CitaAsignadaService {

    @Autowired
    private CitaAsignadaRepository citaAsignadaRepository;

    public List<CitaAsignadaDTO> obtenerCitasPorDocumentoPaciente(String documentoIdentidad) {
        return citaAsignadaRepository.obtenerCitasPorDocumentoPaciente(documentoIdentidad);
    }
}
