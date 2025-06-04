package com.proyecto.medihealth.medico.services;

import com.proyecto.medihealth.common.models.Consultorios;
import com.proyecto.medihealth.medico.dtos.ConsultorioDTO;
import com.proyecto.medihealth.medico.repositories.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    @Autowired
    public ConsultorioService(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public List<ConsultorioDTO> obtenerTodosLosConsultorios() {
        List<Consultorios> consultorios = consultorioRepository.findAll();
        return consultorios.stream()
                .map(c -> new ConsultorioDTO(c.getIdConsultorio(), c.getNumeroConsultorio()))
                .collect(Collectors.toList());
    }


}
